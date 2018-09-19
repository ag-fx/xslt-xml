import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "dk.rn.its"
version = "1.0-SNAPSHOT"

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("no.tornado:fxlauncher-gradle-plugin:1.0.18")
    }
}

plugins {
    java
    kotlin("jvm") version "1.2.70"
    id("no.tornado.fxlauncher") version "1.0.20"
}

fxlauncher {
    applicationVendor = "Thomas Bohsen Schmidt"
    applicationUrl = "https://github.com/bohsen/testlink-xml"
    applicationMainClass = "app.XsltTransformerApp"
    acceptDowngrade = false
    deployTarget = "$buildDir"
}

repositories {
    mavenCentral()

}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("no.tornado","tornadofx", "1.7.16")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}