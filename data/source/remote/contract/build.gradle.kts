plugins {
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    apiDependencies()
    implementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.coroutines.core)
}

fun DependencyHandlerScope.apiDependencies() {
    api(project(":data:api:model"))
    api(project(":data:model"))
}
