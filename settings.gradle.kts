pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.2.2"
        id("com.android.library") version "8.2.2"
        id("org.jetbrains.kotlin.android") version "1.9.22"
        id("androidx.navigation.safeargs")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Sample Movies - UI Test"
include(":app")