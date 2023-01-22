plugins {
    java
}

repositories {
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    mavenCentral()
}

dependencies {
    implementation("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}

group = "com.matthewcash.network"
version = "1.0.0"
description = "Matthew_Cash Creative Tweaks"
java.sourceCompatibility = JavaVersion.VERSION_17
