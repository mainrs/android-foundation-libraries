plugins {
    with(Deps.Plugins) {
        id(androidLibrary)
        id(kotlinAndroid)
        id(mavenPublish)
    }
}

group = Publishing.group
version = "1.0.0"

android {
    namespace = "net.zerotask.libraries.android.foundation.lifecycle"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        aarMetadata {
            minCompileSdk = 21
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
       release {
           isMinifyEnabled = false
           proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
       }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    with(Deps) {
        implementation(timber)
        implementation(Deps.Androidx.lifecycle)
    }
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = Publishing.group
                artifactId = "lifecycle"
                version = "1.0.0"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}
