plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Jar>("createJar") {
    archiveFileName.set("myapp.jar")
    destinationDirectory.set(file("$buildDir/libs"))
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
    from(sourceSets.main.get().output)
}

tasks.register<Exec>("buildDocker") {
    commandLine("docker", "build", "-t", "myapp", "-f", "docker/Dockerfile", ".")
    workingDir = file(projectDir)
}
