repositories {
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}

gradlePlugin {
    val commonJavaLibPlugin = "common-java-library-plugin"
    plugins {
        register(commonJavaLibPlugin) {
            id = commonJavaLibPlugin
            implementationClass = "CommonJavaLibraryPlugin"
        }
    }
}
