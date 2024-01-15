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

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:8.2.1")
}
