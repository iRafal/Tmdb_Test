plugins {
    id(GradleConfig.Plugins.KOTLINX_SERIALIZATION)
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    implementationDependencies()
    testImplementation(libs.junit)
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.kotlinx.dateTime)
}
