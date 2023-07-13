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
    implementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":feature:home:reducer"))

    implementation(project(":feature:movie:details:reducer"))

    implementation(project(":store:base"))
    implementation(project(":store:env"))
    implementation(project(":store:feature"))
    implementation(project(":store:state"))
    implementation(project(":store:action"))
    implementation(project(":data:source:remote:contract"))
    implementation(project(":data:source:local:contract"))
    implementation(project(":data:model"))
}
