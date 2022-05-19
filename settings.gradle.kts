pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    val androidPluginVersion: String by settings
    val kotlinJvmVersion: String by settings
    val multiplatformResourcesPlugin: String by settings

    plugins {
        kotlin("android") version kotlinJvmVersion
        kotlin("multiplatform") version kotlinJvmVersion
        kotlin("plugin.serialization") version kotlinJvmVersion
        plugins {
            id("com.android.application") version androidPluginVersion
            id("com.android.library") version androidPluginVersion
            id("dev.icerock.mobile.multiplatform-resources") version multiplatformResourcesPlugin
        }
    }
}

rootProject.name = "For_The_Widgets"
include(":Stock_Tracker")
include(":Shared_Stock_Tracker")