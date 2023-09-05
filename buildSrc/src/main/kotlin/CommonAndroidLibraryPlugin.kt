import com.android.build.gradle.BaseExtension
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

class CommonAndroidLibraryPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(GradleConfig.Plugins.ANDROID_LIBRARY)
        target.plugins.apply(GradleConfig.Plugins.KOTLIN_ANDROID)
        target.plugins.apply(GradleConfig.Plugins.KOTLIN_KAPT)

        val androidExtension = target.extensions.getByName("android")
        with (androidExtension as BaseExtension) {
            compileSdkVersion(GradleConfig.Android.compileSdk)

            defaultConfig {
                minSdk = GradleConfig.Android.minSdk
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = GradleConfig.Android.isMinifyEnabledDebug
                }
                getByName("release") {
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
        }
    }
}
