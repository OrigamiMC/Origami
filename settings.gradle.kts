pluginManagement {
    repositories {
        mavenLocal()
        maven(url = "https://maven.fancyspaces.net/origami/releases")
        maven(url = "https://maven.fancyspaces.net/fancyinnovations/releases")
        gradlePluginPortal()
    }
}

rootProject.name = "origami"

include(":origami-api")
include(":origami-server")
