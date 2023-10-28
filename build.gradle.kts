// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.ANDROID_APPLICATION).version(BuildDependencyVersions.ANDROID_APP_LIBRARY_VERSION).apply(false)
    id(BuildPlugins.ANDROID_LIBRARY).version(BuildDependencyVersions.ANDROID_APP_LIBRARY_VERSION).apply(false)
    kotlin(BuildPlugins.ANDROID).version(BuildDependencyVersions.KOTLIN_VERSION).apply(false)
//    kotlin(BuildPlugins.MULTIPLATFORM).version(BuildDependencyVersions.KOTLIN_VERSION).apply(false)
    id(BuildPlugins.HILT).version(BuildDependencyVersions.HILT_VERSIOM).apply(false)
}

buildscript {
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${BuildDependencyVersions.NAV_VERSION}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}