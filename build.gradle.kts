plugins {
    java
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}

group = "com.myolang"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    all{
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa"){
        exclude("org.hibernate.orm:hibernate-core:6.2.6.Final")

    }
    implementation("org.hibernate.orm:hibernate-core:6.3.0.CR1") // 6.2.6 Version에서 단방향 Mapping이 안된다는 에러가 발생하여 추가.

    //implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    //implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.2")


    implementation("me.paulschwarz:spring-dotenv:4.0.0")
    implementation("org.springframework.boot:spring-boot-starter-log4j2:3.1.2")
    testImplementation("org.projectlombok:lombok:1.18.22")


    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")


    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    //testImplementation("org.springframework.security:spring-security-test")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0")

    implementation("org.springframework.security:spring-security-crypto:6.1.3")


    runtimeOnly("org.postgresql:postgresql")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
