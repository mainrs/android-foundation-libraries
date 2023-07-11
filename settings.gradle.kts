pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "foundations"

include(":android-foundation")
include(":androidx-compose-datastore")
include(":androidx-compose-e2e")
include(":androidx-datastore")
include(":androidx-lifecycle")
include(":androidx-room")
