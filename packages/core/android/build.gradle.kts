plugins {
    kotlin("jvm") version "2.2.21"
    id("org.jetbrains.dokka") version "1.9.20"
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    testImplementation("junit:junit:4.13.2")
}

tasks.test {
    useJUnit()
}

tasks.register<Copy>("copyDokkaToDocs") {
    dependsOn(tasks.named("dokkaHtml"))
    from(layout.buildDirectory.dir("dokka/html"))
    into(layout.projectDirectory.dir("../../docs/api/android"))
}
