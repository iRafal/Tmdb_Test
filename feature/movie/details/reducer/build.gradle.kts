plugins {
    id(GradleConfig.Plugins.ANDROID_LIBRARY)
    id(GradleConfig.Plugins.KOTLIN_ANDROID)
    id(GradleConfig.Plugins.KOTLIN_KAPT)
}

android {
    namespace = "${GradleConfig.Android.applicationId}.feature.movie.details.reducer"
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

fun DependencyHandlerScope.kaptDependencies() {
    kapt(libs.dagger.compiler)
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":store:base"))
    implementation(project(":store:env"))
    implementation(project(":store:feature"))
    implementation(project(":store:state"))

    implementation(project(":data:source:remote:contract"))
    implementation(project(":data:source:local:contract"))
    implementation(project(":data:model"))

    implementation(project(":feature:movie:details:action"))

    implementation(project(":util"))

    implementation(libs.dagger)
}

fun DependencyHandlerScope.testImplementationDependencies() {
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.kotlinx.dateTime)
}
