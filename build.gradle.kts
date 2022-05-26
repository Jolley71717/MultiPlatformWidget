//buildscript {
//    repositories {
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
////        classpath("com.android.tools.build:gradle:7.2.0")
//        classpath("dev.icerock.moko:resources-generator:0.20.0")
//    }
//}
//
//repositories {
//    gradlePluginPortal()
//    google()
//    mavenCentral()
//}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

extensions.findByName("buildScan")?.withGroovyBuilder {
    setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
    setProperty("termsOfServiceAgree", "yes")
}
