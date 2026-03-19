pluginManagement {
    repositories {
        mavenLocal()
        maven(url = "https://maven.fancyspaces.net/origami/releases")
        gradlePluginPortal()
    }
}

rootProject.name = "origami"

include(":origami-api")
include(":origami-server")
