buildscript {
    repositories {
        maven { url = uri("https://plugins.gradle.org/m2/") }
        mavenCentral()
        google()
    }

    dependencies {
        classpath(libs.gradle)
        classpath(libs.ktlint.plugin)
        classpath(libs.kotlin.gradle)
        classpath(libs.kotlin.serialization)
        classpath(libs.realm.plugin)
        classpath(libs.objectBox)
        classpath(libs.detekt)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    /**
     * ./gradlew detekt
     * ./gradlew detektBaseline - prefer using this one
     */
    apply(plugin = "io.gitlab.arturbosch.detekt")
}

/**
 * Run all tests
 * https://developer.android.com/studio/test/command-line
 *
 * ./gradlew test
 *
 * ./gradlew connectedAndroidTest
 * ./gradlew cAT
 */

/**
 * Lint terminal https://developer.android.com/studio/write/lint
 * ./gradlew lint
 * ./gradlew lintDebug
 * ./gradlew lintRelease
 */

/**
 * Mac
 * chmod +x gradlew (id needed, https://stackoverflow.com/questions/17668265/gradlew-permission-denied)
 * ./gradlew ktlintCheck
 * ./gradlew ktlintFormat
 *
 * Windows
 * gradlew ktlintCheck
 * gradlew ktlintFormat
 */


subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent

    repositories {
        // Required to download KtLint
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
        verbose.set(true)
        android.set(true)

        outputToConsole.set(true)
        outputColorName.set("RED")

        relative.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(false) // https://github.com/pinterest/ktlint/blob/master/ktlint-ruleset-experimental/src/main/kotlin/com/pinterest/ktlint/ruleset/experimental/ExperimentalRuleSetProvider.kt
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

// https://detekt.dev/docs/gettingstarted/gradle#kotlin-dsl-3
tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    config.setFrom(file("config/detekt/detekt.yml"))
    baseline.set(file("${rootProject.projectDir}/config/detekt/baseline.xml"))
    include("**/*.kt")
    exclude("**/build/**")
    setSource(projectDir)
    allRules = false
    parallel = false
    disableDefaultRuleSets = false
    buildUponDefaultConfig = true
    debug = false
    ignoreFailures = false
    basePath = projectDir.absolutePath
    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
        md.required.set(true)
    }
    jvmTarget = GradleConfig.javaVersionAsString
}

/**
 * https://detekt.dev/docs/introduction/baseline/
 */
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
    jvmTarget = GradleConfig.javaVersionAsString
    description = "Overrides current baseline."
    buildUponDefaultConfig.set(true)
    ignoreFailures.set(true)
    parallel.set(true)
    setSource(files(rootDir))
    config.setFrom(files("config/detekt/detekt.yml"))
    baseline.set(file("config/detekt/baseline.xml"))
    include("**/*.kt")
    include("**/*.kts")
    exclude("**/resources/**")
    exclude("**/build/**")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}