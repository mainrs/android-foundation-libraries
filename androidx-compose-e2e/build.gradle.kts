plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

group = "com.github.mainrs"
version = "1.0.0"

android {
    namespace = "net.zerotask.libraries.android.foundation.compose.e2e"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
       release {
           isMinifyEnabled = false
           proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
       }
    }
}

dependencies {
    api("com.google.accompanist:accompanist-systemuicontroller:0.24.13-rc")
    compileOnly("androidx.compose.foundation:foundation:1.2.0-rc02")
}
