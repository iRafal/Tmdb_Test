plugins {
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    implementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":data:source:remote:contract"))
    implementation(project(":data:source:local:contract"))
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.coroutines.core)
}
