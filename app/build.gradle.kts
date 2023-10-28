plugins {
    applaySampleAndroisAppPlugins()
}

android {
    namespace = AppConfig.NAMESPACE
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = BuildDependencyVersions.JVM_TARGET
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(":core"))
    implementation(project(":advancedrecyclerview"))
    addBaseDependencies()
    addLiveCycleDependencies()
    addUIDependencies()
    addRetrofitDependencies()
    addRxJavaDependencies()
    addNavigationDependencies()
    addHiltDependencies()

    addUnitTestDependencies()
    addAndroidTestDependencies()
}