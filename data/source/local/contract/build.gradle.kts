plugins {
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    api(project(":data:model"))
    implementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.coroutines.core)
}
