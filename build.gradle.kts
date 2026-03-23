plugins {
    id("com.gradleup.shadow") version "9.3.1" apply false
    id("com.origamimc.strata-workspace") version "1.0.4"
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven(url = "https://maven.fancyspaces.net/origami/releases")
        maven(url = "https://repo.fancyinnovations.com/releases")
        maven(url = "https://jitpack.io")
    }
}

tasks.register("printVersion") {
    group = "origami"

    doLast {
        print(project.version)
    }
}

tasks.register("printChannel") {
    group = "origami"

    doLast {
        print(project.properties["channel"])
    }
}

tasks.register("printMinecraftVersion") {
    group = "origami"

    doLast {
        print(project.properties["minecraftVersion"])
    }
}