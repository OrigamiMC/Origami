pluginManagement {
    repositories {
        mavenLocal()
        maven(url = "https://maven.fancyspaces.net/origami/releases") {
            credentials(HttpHeaderCredentials::class) {
                name = "Authorization"
                value = "ApiKey " + providers
                    .gradleProperty("fancyspacesApiKey")
                    .orElse(
                        providers
                            .environmentVariable("FANCYSPACES_API_KEY")
                            .orElse("")
                    )
                    .get()
            }

            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
        maven(url = "https://maven.fancyspaces.net/fancyinnovations/releases")
        gradlePluginPortal()
    }
}

rootProject.name = "origami"

include(":origami-api")
include(":origami-server")
