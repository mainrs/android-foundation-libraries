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
    namespace = "net.zerotask.libraries.android.foundation.compose.datastore"
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
        compose = true
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
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtension
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":androidx-datastore"))
    implementation(platform(Deps.Compose.bom))
    implementation(Deps.Androidx.datastore)
    implementation(Deps.Compose.runtime)
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId =  Publishing.group
                artifactId = "compose-datastore"
                version = "1.0.0"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}