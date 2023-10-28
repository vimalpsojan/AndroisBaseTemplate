object AppDependencies {
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependencyVersions.CORE_KTX}"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${BuildDependencyVersions.KOTLIN_VERSION}"
    const val SUPPORT_V4 = "androidx.legacy:legacy-support-v4:${BuildDependencyVersions.LEGACY_SUPPORT}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${BuildDependencyVersions.APP_COMPAT}"

    const val MATERIAL = "com.google.android.material:material:${BuildDependencyVersions.MATERIAL}"

    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependencyVersions.CONSTRAINT_LAYOUT}"

    const val PREFERENCE = "androidx.preference:preference-ktx:${BuildDependencyVersions.PREFERENCE_VERSION}"

    // lifecycle

    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependencyVersions.LIFECYCLE_VERSION}"
    const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependencyVersions.LIFECYCLE_VERSION}"
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependencyVersions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${BuildDependencyVersions.LIFECYCLE_VERSION}"

    // life cycle UI
    const val FRAGMENT = "androidx.fragment:fragment-ktx:${BuildDependencyVersions.FRAGMENT_VERSION}"
    // test
    const val FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${BuildDependencyVersions.FRAGMENT_VERSION}"

    // navigation
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependencyVersions.NAV_VERSION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependencyVersions.NAV_VERSION}"
    // test
    const val NAVIGATION_TEST ="androidx.navigation:navigation-testing:${BuildDependencyVersions.NAV_VERSION}"

    // retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependencyVersions.RETROFIT}"
    const val GSON = "com.google.code.gson:gson:${BuildDependencyVersions.GSON}"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${BuildDependencyVersions.RETROFIT}"
    const val LOGGING_INTERCEPTO = "com.squareup.okhttp3:logging-interceptor:${BuildDependencyVersions.LOGGING_INTERCEPTO}"

    const val RX_RETROFIT = "com.squareup.retrofit2:adapter-rxjava3:${BuildDependencyVersions.RETROFIT}"

    // rx java
    const val RX_JAVA = "io.reactivex.rxjava3:rxjava:${BuildDependencyVersions.RXJAVA}"
    const val RX_KOTLIN = "io.reactivex.rxjava3:rxkotlin:${BuildDependencyVersions.RXKOTLIN}"
    const val RX_ANDROID = "io.reactivex.rxjava3:rxandroid:${BuildDependencyVersions.RXANDROID}"

    // hilt
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${BuildDependencyVersions.HILT_VERSIOM}"
    const val HILT_ANDROID_COMPILE = "com.google.dagger:hilt-android-compiler:${BuildDependencyVersions.HILT_VERSIOM}"
    const val HILT_COMPILE = "androidx.hilt:hilt-compiler:${BuildDependencyVersions.HILT_VIEW_MODEL}"
    // test
    const val HILT_TEST = "com.google.dagger:hilt-android-testing:${BuildDependencyVersions.HILT_VERSIOM}"

    // Test
    const val JUNIT = "junit:junit:${BuildDependencyVersions.JUNIT}"

    // android Test
    const val TEST_EXT = "androidx.test.ext:junit:${BuildDependencyVersions.TEST_EXT_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${BuildDependencyVersions.ESPRESSO_CORE}"
}