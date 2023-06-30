plugins {
    id(GradleConfig.Plugins.ANDROID_LIBRARY)
    id(GradleConfig.Plugins.KOTLIN_ANDROID)
    id(GradleConfig.Plugins.KOTLIN_KAPT)
}

android {
    namespace = "${GradleConfig.Android.applicationId}.store.app"
    compileSdk = GradleConfig.Android.compileSdk

    defaultConfig {
        minSdk = GradleConfig.Android.minSdk
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        debug {
            isMinifyEnabled = GradleConfig.Android.isMinifyEnabledDebug
        }
        release {
            isMinifyEnabled = GradleConfig.Android.isMinifyEnabledRelease
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("consumer-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = GradleConfig.javaVersion
        targetCompatibility = GradleConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = GradleConfig.javaVersionAsString
    }
}

dependencies {
    implementationDependencies()
    apiDependencies()
    kaptDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":util"))
    implementation(libs.dagger)
}

fun DependencyHandlerScope.apiDependencies() {
    api(project(":store:reducer:app"))
    api(project(":store:base"))
    api(project(":store:state"))
    api(project(":store:env"))
    api(project(":store:feature"))
    api(project(":feature:home:action"))
    api(project(":data:model"))
}

fun DependencyHandlerScope.kaptDependencies() {
    kapt(libs.dagger.compiler)
}
