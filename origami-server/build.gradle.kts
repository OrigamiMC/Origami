plugins {
    id("java-library")
    id("com.gradleup.shadow")
}

sourceSets {
    create("minecraft") { }
}

dependencies {
    implementation(project(":origami-api"))
//    implementation(sourceSets["minecraft"].output)

    implementation("org.jetbrains:annotations:26.1.0")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        archiveBaseName.set("Origami")
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

        val props = mapOf(
            "version" to project.version,
            "channel" to project.properties["channel"],
            "build" to (System.getenv("ORIGAMI_BUILD") ?: "").ifEmpty { "dev" },
            "commit" to (System.getenv("ORIGAMI_COMMIT") ?: "").ifEmpty { "unknown" }
        )
        inputs.properties(props)
        filesMatching("origami-version.json") {
            expand(props)
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}
