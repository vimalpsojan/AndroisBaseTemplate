plugins {
    applayAndroisLibraryPlugins()
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = "com.vimal.advancedrecyclerview"

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation (AppDependencies.KOTLIN_STDLIB)
    implementation (AppDependencies.SUPPORT_V4)
    implementation (AppDependencies.MATERIAL)

    addUnitTestDependencies()

    androidTestImplementation (AppDependencies.JUNIT)
    androidTestImplementation (AppDependencies.TEST_EXT)
    androidTestImplementation (AppDependencies.ESPRESSO_CORE)
}