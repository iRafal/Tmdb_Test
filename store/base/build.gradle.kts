plugins {
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.coroutines.core)
}
