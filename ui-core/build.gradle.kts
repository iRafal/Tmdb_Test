plugins {
    id(GradleConfig.Plugins.ANDROID_LIBRARY)
    id(GradleConfig.Plugins.KOTLIN_ANDROID)
    id(GradleConfig.Plugins.KOTLIN_KAPT)
}

android {
    namespace = "${GradleConfig.Android.applicationId}.ui.core"
    compileSdk = GradleConfig.Android.compileSdk

    defaultConfig {
        minSdk = GradleConfig.Android.minSdk
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions.jvmTarget = GradleConfig.javaVersionAsString
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.get()
}

dependencies {
    implementationDependencies()
    apiDependencies()
    debugApiDependencies()
    kaptDependencies()
    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.ui.test.android)
}

fun DependencyHandlerScope.kaptDependencies() {
    kapt(libs.dagger.compiler)
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":store:app-store"))
    implementation(project(":data:model"))
    implementation(libs.dagger)
}

fun DependencyHandlerScope.apiDependencies() {
    api(project(":util"))

    api(libs.androidx.core)

    api(libs.compose.animation)
    api(libs.compose.compiler)
    api(libs.compose.foundation)
    api(libs.compose.runtime)
    api(libs.compose.activity)
    api(libs.compose.constraintLayout)
    api(libs.compose.navigation)
    api(libs.compose.ui)
    api(libs.compose.ui.preview)
    api(libs.compose.material)
    api(libs.compose.material3)

    api(libs.coil)
    api(libs.coil.compose)
    api(libs.okHttp3.loggingInterceptor)

    api(libs.logging)
    api(libs.kotlinx.dateTime)
}

fun DependencyHandlerScope.debugApiDependencies() {
    debugApi(libs.compose.ui.tooling.debug)
    debugImplementation(libs.compose.ui.test.manifest.debug)
}
