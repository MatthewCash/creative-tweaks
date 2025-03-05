plugins {
    java
    id("com.gradleup.shadow") version "9.0.0-beta9"
}

repositories {
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    maven { url = uri("https://repo.codemc.io/repository/maven-public/") }
    mavenCentral()
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
    implementation("de.tr7zw:item-nbt-api:2.14.1")
}

tasks.named("build") {
    dependsOn(tasks.named("shadowJar"))
}

group = "com.matthewcash.network"
version = "1.0.0"
description = "Matthew_Cash Creative Tweaks"
java.sourceCompatibility = JavaVersion.VERSION_17
