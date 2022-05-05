pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    val kotlinJvmVersion: String by settings
    plugins {
        kotlin("multiplatform") version kotlinJvmVersion
        kotlin("plugin.serialization") version kotlinJvmVersion
        kotlin("android") version kotlinJvmVersion
    }
}

rootProject.name = "For_The_Widgets"
include(":Stock_Tracker")
include(":Shared_Stock_Tracker")