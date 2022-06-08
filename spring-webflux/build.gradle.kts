import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.remi.webflux"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.7")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-opt-in=kotlin.RequiresOptIn")
        jvmTarget = "1.8"
    }
}

tasks.getByName<BootRun>("bootRun") {
    mainClass.set("com.remi.webflux.Application")
}