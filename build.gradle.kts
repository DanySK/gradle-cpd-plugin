import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
    groovy
    jacoco
    `java-gradle-plugin`
    alias(libs.plugins.coveralls)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.gradlePluginPublish)
    alias(libs.plugins.multiJvmTesting)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.taskTree)
}

description = "Gradle plugin to find duplicate code using PMDs copy/paste detection (= CPD)"
group = "org.danilopianini"

inner class ProjectInfo {
    val longName = "CPD Gradle Plugin"
    val website = "https://github.com/DanySK/$name"
    val vcsUrl = "$website.git"
    val scm = "scm:git:$website.git"
    val pluginImplementationClass = "de.aaschmid.gradle.plugins.cpd.CpdPlugin"
    val tags = listOf("template", "kickstart", "example")
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
    compileOnly("net.sourceforge.pmd:pmd-dist:7.2.0")

    testImplementation("net.sourceforge.pmd:pmd-dist:7.2.0")
    testImplementation("com.google.guava:guava:33.1.0-jre")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.assertj:assertj-core:3.25.3")
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.11.0")

    "integTestImplementation"("org.assertj:assertj-core:3.25.3")
    "integTestImplementation"("org.junit.vintage:junit-vintage-engine:5.10.2")
    "integTestImplementation"("org.spockframework:spock-core:2.3-groovy-3.0") {
        exclude(module = "groovy-all")
    }
}

jacoco {
    toolVersion = "0.8.12"
}

multiJvm {
    jvmVersionForCompilation.set(8)
    testByDefaultWith(latestLts, latestJavaSupportedByGradle)
}

val javaForTests: JavaToolchainSpec.() -> Unit = { languageVersion.set(JavaLanguageVersion.of(11)) }
val javaTestCompiler = javaToolchains.compilerFor(javaForTests)
val javaTestLauncher = javaToolchains.launcherFor(javaForTests)

tasks {

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
    jar {
        manifest {
            val now = LocalDate.now()
            val today = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            attributes(
                    "Built-By" to "Gradle ${gradle.gradleVersion}",
                    "Built-Date" to today, // using now would destroy incremental build feature
                    "Specification-Title" to "gradle-cpd-plugin",
                    "Specification-Version" to project.version,
                    "Specification-Vendor" to "Andreas Schmid, service@aaschmid.de",
                    "Implementation-Title" to "gradle-cpd-plugin",
                    "Implementation-Version" to project.version,
                    "Implementation-Vendor" to "Andreas Schmid, service@aaschmid.de"
            )
        }
    }
    test {
        useJUnitPlatform()
        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
    check {
        dependsOn(integTest)
    }
    jacocoTestReport {
        executionData(withType(Test::class).toSet())
        reports {
            xml.required.set(true)
            html.required.set(false)
        }
        dependsOn(withType(Test::class))
    }
}

gradlePlugin {
    pluginSourceSet(sourceSets.main.get())
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

/*
 * Publication on Maven Central and the Plugin portal
 */
publishOnCentral {
    projectLongName.set(info.longName)
    projectDescription.set(description ?: TODO("Missing description"))
    projectUrl.set(info.website)
    scmConnection.set(info.scm)
    repository("https://maven.pkg.github.com/DanySK/${rootProject.name}".toLowerCase(), name = "github") {
        user.set("danysk")
        password.set(System.getenv("GITHUB_TOKEN"))
    }
    publishing {
        publications {
            withType<MavenPublication> {
                pom {
                    developers {
                        developer {
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
