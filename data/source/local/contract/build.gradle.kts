plugins {
    id(GradleConfig.Plugins.JAVA_LIBRARY)
    id(GradleConfig.Plugins.KOTLIN)
    id(GradleConfig.Plugins.KOTLIN_JVM)
}

java {
    sourceCompatibility = GradleConfig.javaVersion
    targetCompatibility = GradleConfig.javaVersion
}

dependencies {
    api(project(":data:model"))
    implementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.coroutines.core)
}
