plugins {
    kotlin("jvm") version "1.8.10" // Обновление Kotlin на более актуальную версию
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.8.10") // Использование актуальной версии Kotlin Test с JUnit 5
    testImplementation("io.mockk:mockk:1.13.5") // Обновление MockK до актуальной версии
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1") // Обновление JUnit до версии 5.9.1
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1") // Обновление JUnit до версии 5.9.1

    implementation("mysql:mysql-connector-java:8.0.30") // Оставляем текущую версию MySQL Connector, если она работает стабильно
}

tasks.test {
    useJUnitPlatform() // Указываем, что используем JUnit 5
}

kotlin {
    jvmToolchain(17) // Оставляем актуальную версию JVM
}


/*
plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.0")
    testImplementation("io.mockk:mockk:1.13.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("mysql:mysql-connector-java:8.0.30")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
 */