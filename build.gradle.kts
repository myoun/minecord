plugins {
    kotlin("jvm") version "1.7.20"
}

group = "dev.cube1"
version = "3.0.0"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    java.toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }

    repositories {
        mavenCentral()
    }
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()

        maven("https://papermc.io/repo/repository/maven-public/")
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation(kotlin("reflection"))
        implementation("io.github.monun:kommand-api:2.14.0")
        implementation("net.dv8tion:JDA:5.0.0-alpha.22") {
            exclude(module = "opus-java")
        }

        compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
    }
}
