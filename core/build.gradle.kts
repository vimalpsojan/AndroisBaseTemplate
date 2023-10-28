plugins {
    applayAndroisLibraryPlugins()
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = "com.vimal.core"

    defaultConfig {
        minSdk = AppConfig.minSdk

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

    buildFeatures {
        dataBinding = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    addBaseDependencies()
    addLiveCycleDependencies()
    addRetrofitDependencies()
    addRxJavaDependencies()
    addNavigationDependencies()

    implementation (AppDependencies.PREFERENCE)
    implementation (AppDependencies.FRAGMENT)

    addUnitTestDependencies()
    addAndroidTestDependencies()
}