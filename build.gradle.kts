// Root build.gradle.kts

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Ivanmw97/kompkit")
            credentials {
                username = (project.findProperty("gpr.user") as? String) ?: System.getenv("USERNAME")
                password = (project.findProperty("gpr.key") as? String) ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}