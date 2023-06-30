plugins {
    id(GradleConfig.Plugins.ANDROID_LIBRARY)
    id(GradleConfig.Plugins.KOTLIN_ANDROID)
    id(GradleConfig.Plugins.KOTLIN_KAPT)
    id(GradleConfig.Plugins.OBJECTBOX)
}

android {
    namespace = "${GradleConfig.Android.applicationId}.data.db.objectBox"
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
    kaptDependencies()
    testImplementationDependencies()
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":util"))
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.dagger)
    implementation(libs.kotlinx.dateTime)
    implementation(libs.logging)
}

fun DependencyHandlerScope.testImplementationDependencies() {
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.kotlinx.dateTime)
}

fun DependencyHandlerScope.kaptDependencies() {
    kapt(libs.dagger.compiler)
}
