plugins {
    kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val klaxon_version = "5.2"
val kluent_version = "1.60"
val junit_version = "5.6.1"
val krangle_version = "0.11"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.beust:klaxon:${klaxon_version}")
    testImplementation("org.amshove.kluent:kluent:${kluent_version}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junit_version}")
    compile("de.mpicbg.scicomp:krangl:${krangle_version}")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}