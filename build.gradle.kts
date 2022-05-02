import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.bundling.Jar
//import org.springframework.boot.gradle.tasks.bundling.BootJar
import java.util.regex.Pattern.compile

plugins {
//    id("org.springframework.boot") version "2.6.7"
//    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    `java-library`
    `maven-publish`


//    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
//tasks {
//    withType<BootJar> {
//        enabled = true
//        classifier = "boot"
//    }
//    withType<Jar> {
//        enabled = true
//    }
//}


//publishing {
//    (publications) {
//        "mavenJava"(MavenPublication::class) {
//            from(components["java"])
//            artifact(tasks["sourcesJar"])
//        }
//    }
//}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.withType<GradleBuild> {
    finalizedBy("publishToMavenLocal")
}