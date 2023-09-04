import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension

class CommonJavaLibraryPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(GradleConfig.Plugins.JAVA_LIBRARY)
        target.plugins.apply(GradleConfig.Plugins.KOTLIN)

        target.extensions.configure(
            EXTENSION_JAVA,
            object : Action<JavaPluginExtension> {
                override fun execute(t: JavaPluginExtension) {
                    t.sourceCompatibility = GradleConfig.javaVersion
                    t.targetCompatibility = GradleConfig.javaVersion
                }
            }
        )
    }

    companion object {
        private const val EXTENSION_JAVA = "java"
    }
}
