plugins {
    id(GradleConfig.Plugins.ANDROID_APPLICATION)
    id(GradleConfig.Plugins.KOTLIN_ANDROID)
    id(GradleConfig.Plugins.KOTLIN_KAPT)
}

android {
    compileSdk = GradleConfig.Android.compileSdk

    defaultConfig {
        applicationId = GradleConfig.Android.applicationId
        minSdk = GradleConfig.Android.minSdk
        targetSdk = GradleConfig.Android.targetSdk

        testInstrumentationRunner = "${GradleConfig.Android.applicationId}.runner.DaggerTestRunner"

        versionCode = 1
        versionName = Version(major = 1, minor = 0, patch = 0).name

        vectorDrawables.useSupportLibrary = true

        setProperty("archivesBaseName", "$applicationId-$versionName-$versionCode")
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isShrinkResources = GradleConfig.Android.isShrinkResourcesDebug
            isMinifyEnabled = GradleConfig.Android.isMinifyEnabledDebug

            kapt {
                arguments {
                    arg("dagger.formatGeneratedSource", "disabled")
                }
            }

            resValue("string", "app_name", "Tmdb-Debug")
        }
        release {
            isShrinkResources = GradleConfig.Android.isShrinkResourcesRelease
            isMinifyEnabled = GradleConfig.Android.isMinifyEnabledRelease

            kapt {
                arguments {
                    arg("dagger.formatGeneratedSource", "enabled")
                }
            }

            // https://stackoverflow.com/questions/60861929/what-is-the-difference-between-consumer-rules-pro-and-proguard-rules-pro-in-andr
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue("string", "app_name", "Tmdb")
        }
    }
    compileOptions {
        sourceCompatibility = GradleConfig.javaVersion
        targetCompatibility = GradleConfig.javaVersion
    }
    kotlinOptions.jvmTarget = GradleConfig.javaVersionAsString
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.get()

    packaging {
        resources {
            this.excludes.addAll(GradleConfig.Android.excludePackagingResources)
        }
    }
    namespace = GradleConfig.Android.applicationId
    lint {
        // https://developer.android.com/studio/write/lint
        baseline = file("lint-baseline.xml")
    }
}

kapt {
    arguments {
        arg("dagger.fastInit", "enabled")
        arg("dagger.fullBindingGraphValidation", "ERROR") //"WARNING"
    }
}

// Ktlint manual integration
// val ktlint by configurations.creating

dependencies {

// Ktlint manual integration
//    ktlint(libs.ktlint) {
//        attributes {
//            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
//        }
//        // ktlint(project(":custom-ktlint-ruleset")) // in case of custom ruleset
//    }
    implementationDependencies()
    testImplementationDependencies()
    androidTestImplementationDependencies()

    kaptDependencies()

    kaptAndroidTest(libs.dagger.compiler)

    // debugImplementationDependencies() //INFO: not used
}

fun DependencyHandlerScope.implementationDependencies() {
    implementation(project(":store:app-store"))
    implementation(project(":data:source:local:impl"))
    implementation(project(":data:source:remote:impl-ktor"))

    implementation(project(":feature:home:ui"))
    implementation(project(":feature:movie:details:ui"))

    implementation(project(":ui-core"))

    implementation(libs.dagger)
    implementation(libs.androidx.work.runtime)
}

fun DependencyHandlerScope.kaptDependencies() {
    kapt(libs.dagger.compiler)
}

fun DependencyHandlerScope.debugImplementationDependencies() {
    debugImplementation(libs.leakCanary.debug)
}

fun DependencyHandlerScope.testImplementationDependencies() {
    testImplementation(libs.junit)

    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)

    testImplementation(libs.kotlin.coroutines.test)
}

fun DependencyHandlerScope.androidTestImplementationDependencies() {
    androidTestImplementation(libs.junit.android.ext)

    androidTestImplementation(libs.espresso)

    androidTestImplementation(libs.kotlin.coroutines.test)

    androidTestImplementation(libs.compose.ui.test.manifest.debug)
    androidTestImplementation(libs.compose.ui.test.junit)
}

// Ktlint manual integration
// val outputDir = "${project.buildDir}/reports/ktlint/"
// val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))
//
// val ktlintCheck by tasks.creating(JavaExec::class) {
//    inputs.files(inputFiles)
//    outputs.dir(outputDir)
//
//    description = "Check Kotlin code style."
//    classpath = ktlint
//    mainClass.set("com.pinterest.ktlint.Main")
//    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
//    args = listOf("src/**/*.kt")
// }
//
// val ktlintFormat by tasks.creating(JavaExec::class) {
//    inputs.files(inputFiles)
//    outputs.dir(outputDir)
//
//    description = "Fix Kotlin code style deviations."
//    classpath = ktlint
//    mainClass.set("com.pinterest.ktlint.Main")
//    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
//    args = listOf("-F", "src/**/*.kt")
// }
