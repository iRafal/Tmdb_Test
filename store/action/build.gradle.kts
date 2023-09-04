plugins {
    id(GradleConfig.Plugins.COMMON_JAVA_LIBRARY)
}

dependencies {
    implementation(project(":store:base"))
    implementation(project(":data:model"))
    implementation(libs.kotlin.stdLib)
}
