plugins {
    id("java-library")
    id("com.gradleup.shadow")
    id("com.origamimc.strata-workspace")
}

strata {
    minecraftVersion.set(project.properties["minecraftVersion"].toString())
    sourceDir.set(file("src/minecraft/java").absolutePath)
}

sourceSets {
    main {
        java {
            srcDirs(layout.projectDirectory.dir("src/minecraft/java"))
        }
        resources {
            srcDirs(layout.projectDirectory.dir("src/minecraft/resources"))
        }
    }
}

dependencies {
    implementation(project(":origami-api"))

    implementation(fileTree(layout.buildDirectory.dir("strata-cache/server-libraries/libraries-"+project.properties["minecraftVersion"].toString())) {
        include("**/*.jar")
    })

    implementation("de.oliver.FancyAnalytics:logger:0.0.10")
    implementation("de.oliver.FancyAnalytics:java-sdk:0.0.6")
    implementation("com.fancyinnovations.fancyspaces:java-sdk:0.0.4")

    implementation("org.jetbrains:annotations:26.1.0")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("org.checkerframework:checker-qual:3.49.0")
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "net.minecraft.server.Main"
        }
    }

    shadowJar {
        archiveClassifier.set("")
        archiveBaseName.set("Origami")
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release = 25
        options.compilerArgs.addAll(listOf("-Xmaxerrs", "10000"))
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
