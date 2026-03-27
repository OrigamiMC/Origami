plugins {
    id("java-library")
    id("maven-publish")
}

dependencies {
    compileOnly("de.oliver.FancyAnalytics:logger:0.0.10")

    compileOnly("org.jetbrains:annotations:26.1.0")
}

tasks {
    publishing {
        repositories {
            maven {
                name = "fancyspacesReleases"
                url = uri("https://maven.fancyspaces.net/origami/releases")

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
        }

        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
                from(project.components["java"])
            }
        }
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release = 25
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}
