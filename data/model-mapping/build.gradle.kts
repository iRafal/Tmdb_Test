plugins {
    id(GradleConfig.Plugins.ANDROID_LIBRARY)
    id(GradleConfig.Plugins.KOTLIN_ANDROID)
    id(GradleConfig.Plugins.KOTLIN_KAPT)
}
android {
    namespace = "${GradleConfig.Android.applicationId}.data.model.mapping"
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
    testImplementation(libs.junit)
}

fun DependencyHandlerScope.kaptDependencies() {
    kapt(libs.dagger.compiler)
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":data:api:model"))
    implementation(project(":data:api:config"))
    implementation(project(":data:model"))
    implementation(project(":util"))

    implementation(libs.dagger)
    implementation(libs.kotlin.stdLib)
    implementation(libs.kotlinx.dateTime)
}
