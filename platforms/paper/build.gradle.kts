plugins {
    id("packetentities.java-library")
    id("packetentities.publishing")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":"))
    compileOnly(libs.packetevents.spigot)
    compileOnly(libs.paper.api)
}

tasks.named("publish") {
    dependsOn(":api:publish")
}

tasks.named("publishToMavenLocal") {
    dependsOn(":api:publishToMavenLocal")
}
