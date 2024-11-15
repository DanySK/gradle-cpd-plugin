plugins {
    id("com.gradle.develocity") version "3.18.2"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.13"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

develocity {
    buildScan {
        termsOfUseUrl.set("https://gradle.com/terms-of-service")
        termsOfUseAgree.set("yes")
        uploadInBackground.set(!System.getenv("CI").toBoolean())
    }
}

gitHooks {
    preCommit {
        tasks("build", "--parallel")
    }
    commitMsg { conventionalCommits() }
    createHooks(true)
}

rootProject.name = "gradle-cpd-plugin"
