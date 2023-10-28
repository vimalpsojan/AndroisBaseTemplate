import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

fun PluginDependenciesSpec.applayAndroisPlugins(): PluginDependenciesSpec {
    kotlin(BuildPlugins.ANDROID)
    kotlin("kapt")
    return this
}

fun PluginDependenciesSpec.applayAndroisLibraryPlugins(): PluginDependenciesSpec {
    id(BuildPlugins.ANDROID_LIBRARY)
    return this.applayAndroisPlugins()
}

fun PluginDependenciesSpec.applayAndroisAppPlugins(): PluginDependenciesSpec {
    id(BuildPlugins.ANDROID_APPLICATION)
    return this.applayAndroisPlugins()
}

fun PluginDependenciesSpec.applaySampleAndroisAppPlugins(): PluginDependenciesSpec {
    var spec = this
    spec.applayAndroisAppPlugins()
    spec.id("androidx.navigation.safeargs.kotlin")
    spec.id("com.google.dagger.hilt.android")
    return spec
}

