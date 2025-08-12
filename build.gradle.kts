import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    groovy
    jacoco
    `java-gradle-plugin`
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.gradlePluginPublish)
    alias(libs.plugins.multiJvmTesting)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.taskTree)
}

description = "Gradle plugin to find duplicate code using PMDs copy/paste detection (= CPD)"
group = "org.danilopianini"

class ProjectInfo {
    val longName = "CPD Gradle Plugin"
    val website = "https://github.com/DanySK/$name"
    val vcsUrl = "$website.git"
    val scm = "scm:git:$website.git"
    val pluginImplementationClass = "de.aaschmid.gradle.plugins.cpd.CpdPlugin"
    val tags = listOf("cpd", "copy-paste", "static analysis")
}
val info = ProjectInfo()

gitSemVer {
    buildMetadataSeparator.set("-")
}

repositories {
    mavenCentral()
}

sourceSets {
    register("integTest") {
        compileClasspath += main.get().output + test.get().output
        runtimeClasspath += main.get().output + test.get().output
    }
}

dependencies {
    implementation(gradleApi())
    implementation(libs.pmd.dist)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.guava)
    testImplementation(libs.bundles.testing.base)
    "integTestImplementation"(platform(libs.junit.bom))
    "integTestImplementation"(libs.bundles.testing.integration) {
        exclude(module = "groovy-all")
    }
}

jacoco {
    toolVersion = "0.8.13"
}

multiJvm {
    jvmVersionForCompilation.set(8)
    testByDefaultWith(latestLts, latestJavaSupportedByGradle)
}

val javaForTests: JavaToolchainSpec.() -> Unit = { languageVersion.set(JavaLanguageVersion.of(11)) }
val javaTestCompiler = javaToolchains.compilerFor(javaForTests)
val javaTestLauncher = javaToolchains.launcherFor(javaForTests)

tasks {

    val copyPmdVersion by registering {
        inputs.file(File(rootProject.rootDir, "gradle/libs.versions.toml"))
        val outputDir = project.layout.buildDirectory
            .dir("resources/main/META-INF/cpd/")
            .map { it.asFile }
        outputs.dir(outputDir)
        doLast {
            val destinationDir = outputDir.get().also { it.mkdirs() }
            val destination = File(destinationDir, "cpd-version")
            file("${rootProject.rootDir.absolutePath}/gradle/libs.versions.toml")
                .useLines { lines ->
                    val regex by lazy { Regex("""pmd\s*=\s*\"([0-9\.]+)\"""") }
                    val version = lines.takeWhile { "[libraries]" !in it }
                        .mapNotNull { regex.matchEntire(it) }
                        .map { it.groupValues[1] }
                        .first()
                    destination.writeText(version)
                }
        }
    }

    withType<JavaCompile>().configureEach {
        dependsOn(copyPmdVersion)
    }

    withType<GroovyCompile>().configureEach {
        dependsOn(copyPmdVersion)
    }

    val integTest by registering(Test::class) {
        inputs.files(jar)
        shouldRunAfter(test)
        testClassesDirs = sourceSets.named("integTest").get().output.classesDirs
        classpath = sourceSets.named("integTest").get().runtimeClasspath
        useJUnitPlatform()
    }

    afterEvaluate {
        compileTestJava.configure {
            javaCompiler.set(javaTestCompiler)
        }
        test.configure {
            javaLauncher.set(javaTestLauncher)
        }
        integTest.configure {
            javaLauncher.set(javaTestLauncher)
        }
    }
    withType<Javadoc>().configureEach {
        isFailOnError = false
    }
    test {
        useJUnitPlatform()
        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
    check.configure {
        dependsOn(integTest)
    }
    jacocoTestReport.configure {
        executionData(withType(Test::class).toSet())
        reports {
            xml.required.set(true)
            html.required.set(false)
        }
        dependsOn(withType(Test::class))
    }
}

gradlePlugin {
    testSourceSets(sourceSets.test.get(), sourceSets.named("integTest").get())
    plugins {
        website.set(info.website)
        vcsUrl.set(info.vcsUrl)
        create("") {
            id = "$group.cpd"
            displayName = info.longName
            description = project.description
            implementationClass = info.pluginImplementationClass
            tags.set(info.tags)
        }
    }
}

signing {
    if (System.getenv()["CI"].equals("true", ignoreCase = true)) {
        val signingKey: String? by project
        val signingPassword: String? by project
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}

publishing.publications {
    create<MavenPublication>("cpd") {
        from(components["java"])
    }
}

/*
 * Publication on Maven Central and the Plugin portal
 */
publishOnCentral {
    projectLongName.set(info.longName)
    projectDescription.set(description ?: TODO("Missing description"))
    projectUrl.set(info.website)
    scmConnection.set(info.scm)
    publishing {
        publications {
            withType<MavenPublication> {
                pom {
                    developers {
                        developer {
                            name.set("Andreas Schmid")
                            email.set("service@aaschmid.de")
                        }
                    }
                    contributors{
                        contributor {
                            name.set("Danilo Pianini")
                            email.set("danilo.pianini@gmail.com")
                            url.set("http://www.danilopianini.org/")
                        }
                    }
                }
            }
        }
    }
}
