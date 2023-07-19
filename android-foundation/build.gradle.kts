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
    namespace = "net.zerotask.libraries.android.foundation"
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

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    with(Deps.Androidx) {
        implementation(paging)
        implementation(startup)
        implementation(core)
    }

    implementation(Deps.timber)
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = Publishing.group
                artifactId = "foundation"
                version = "1.0.0"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}
