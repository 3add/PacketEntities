plugins {
    `java-library`
}

val javaVersion = 21

group = "dev.threeadd.packetentities"
version = "1.0-SNAPSHOT"

configurations.all {
    exclude("org.checkerframework", "checker-qual")
}

val adventureVersion = libs.adventure.api.get().version ?: ""
val packeteventsVersion = libs.packetevents.api.get().version ?: ""

repositories {
    if (adventureVersion.endsWith("-SNAPSHOT"))
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")

    if (packeteventsVersion.endsWith("-SNAPSHOT"))
        maven(url = "https://repo.codemc.io/repository/maven-snapshots/")

    maven(url = "https://repo.codemc.io/repository/maven-releases/")
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }

    modularity.inferModulePath.set(true)

    withSourcesJar()
    withJavadocJar()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
