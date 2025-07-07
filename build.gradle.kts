plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"
//val jooqVersion = "3.14.16"
val jooqVersion = "3.18.14"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jooq:jooq:$jooqVersion")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}