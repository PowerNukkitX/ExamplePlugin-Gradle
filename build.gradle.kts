plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://jitpack.io")
    maven("https://repo.opencollab.dev/maven-releases/")
    maven("https://repo.opencollab.dev/maven-snapshots/")
}

group = "cn.powernukkitx"
version = "1.0.0-SNAPSHOT"
description = "powernukkitx exemple plugin"
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("cn.powernukkitx:powernukkitx:1.20.50-r1")
}

java {
    withSourcesJar()
    withJavadocJar()
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/resources")
        }
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xpkginfo:always")
    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
    jvmArgs(listOf("--add-opens", "java.base/java.lang=ALL-UNNAMED"))
    jvmArgs(listOf("--add-opens", "java.base/java.io=ALL-UNNAMED"))
}
