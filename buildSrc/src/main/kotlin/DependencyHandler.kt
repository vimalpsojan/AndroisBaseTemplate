import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)


fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)


fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)


fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)


fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)


fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.kaptAndroidTest(dependencyNotation: String): Dependency? =
    add("kaptAndroidTest", dependencyNotation)

fun DependencyHandler.addBaseDependencies(){
    implementation(AppDependencies.KOTLIN_STDLIB)
    implementation(AppDependencies.CORE_KTX)
}

fun DependencyHandler.addLiveCycleDependencies(){
    implementation (AppDependencies.LIFECYCLE_RUNTIME)
    implementation (AppDependencies.VIEWMODEL)
    implementation (AppDependencies.LIVE_DATA)
    implementation (AppDependencies.LIFECYCLE_COMMON)
}

fun DependencyHandler.addUIDependencies(){
    implementation (AppDependencies.APP_COMPAT)
    implementation (AppDependencies.MATERIAL)
    implementation (AppDependencies.CONSTRAINT_LAYOUT)
}

fun DependencyHandler.addRetrofitDependencies() {
    ///retrofit
    implementation(AppDependencies.RETROFIT)
    implementation(AppDependencies.GSON)
    implementation(AppDependencies.CONVERTER_GSON)
    implementation(AppDependencies.LOGGING_INTERCEPTO)
    //RxJava retrofit
    implementation(AppDependencies.RX_RETROFIT)
}

fun DependencyHandler.addRxJavaDependencies() {
    // RxJava
    implementation (AppDependencies.RX_JAVA)
    //RxKotline
    implementation (AppDependencies.RX_KOTLIN)
    // RxAndroid
    implementation (AppDependencies.RX_ANDROID)
}

fun DependencyHandler.addNavigationDependencies() {
    implementation (AppDependencies.NAVIGATION_FRAGMENT)
    implementation (AppDependencies.NAVIGATION_UI)
    //test
    androidTestImplementation (AppDependencies.NAVIGATION_TEST)
}

fun DependencyHandler.addHiltDependencies() {
    //Hilt core dependencies Injection
    implementation (AppDependencies.HILT_ANDROID)
    kapt (AppDependencies.HILT_ANDROID_COMPILE)
    kapt (AppDependencies.HILT_COMPILE)
    // test
    androidTestImplementation (AppDependencies.HILT_TEST)
    kaptAndroidTest (AppDependencies.HILT_ANDROID_COMPILE)
}

fun DependencyHandler.addUnitTestDependencies() {
    testImplementation (AppDependencies.JUNIT)
}

fun DependencyHandler.addAndroidTestDependencies() {
    //Dependencies for instrumentation tests
    androidTestImplementation (AppDependencies.JUNIT)
    androidTestImplementation (AppDependencies.TEST_EXT)
    androidTestImplementation (AppDependencies.ESPRESSO_CORE)

    debugImplementation (AppDependencies.FRAGMENT_TESTING)
}