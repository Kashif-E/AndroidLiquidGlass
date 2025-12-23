plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose.multiplatform)
    id("com.vanniktech.maven.publish")
}

kotlin {
    androidTarget()

    iosArm64()
    iosSimulatorArm64()
    iosX64()

    jvmToolchain(21)

    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xcontext-parameters",
            "-Xexpect-actual-classes"
        )
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.compose.foundation)
                implementation(libs.androidx.compose.ui)
                implementation(libs.androidx.compose.ui.graphics)
            }
        }
    }
}

android {
    namespace = "com.kyant.backdrop"
    compileSdk = 36
    buildToolsVersion = "36.1.0"

    defaultConfig {
        minSdk = 21
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }
}

mavenPublishing {
    publishToMavenCentral()
    // signAllPublications() // Disabled for local development - enable for release

    coordinates("io.github.kashif", "backdropkmp", "0.0.8-alpha11")

    pom {
        name.set("BackdropKMP")
        description.set("Compose Multiplatform blur and Liquid Glass effects")
        inceptionYear.set("2025")
        url.set("https://github.com/AKashif1/KMPLiquidGlass")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("AKashif1")
                name.set("Kashif")
                url.set("https://github.com/AKashif1")
            }
        }
        scm {
            url.set("https://github.com/AKashif1/KMPLiquidGlass")
            connection.set("scm:git:git://github.com/AKashif1/KMPLiquidGlass.git")
            developerConnection.set("scm:git:ssh://git@github.com/AKashif1/KMPLiquidGlass.git")
        }
    }
}
