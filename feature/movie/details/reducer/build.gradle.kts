plugins {
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    implementationDependencies()
    testImplementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":store:base"))
    implementation(project(":store:env"))
    implementation(project(":store:feature"))
    implementation(project(":store:state"))
    implementation(project(":store:action"))

    implementation(project(":data:source:remote:contract"))
    implementation(project(":data:source:local:contract"))
    implementation(project(":data:model"))
}

fun DependencyHandlerScope.testImplementationDependencies() {
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.kotlinx.dateTime)
}
