pluginManagement {
    repositories {
        mavenLocal()
        maven(url = "https://maven.fancyspaces.net/fancyinnovations/snapshots")
        maven(url = "https://maven.fancyspaces.net/fancyinnovations/releases")
        gradlePluginPortal()
    }
}

rootProject.name = "origami"

include(":origami-api")
include(":origami-server")
