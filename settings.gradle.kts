pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("'https://maven.google.com")
        }
    }
}

rootProject.name = "TemplateProject"

include(":advancedrecyclerview")
include(":core")
include(":app")