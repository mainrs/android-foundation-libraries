object Publishing {
    const val group = "com.github.mainrs"
}

object Versions {
    const val accompanistSystemUi = "0.30.1"
    const val accompanistPermissions = "0.30.1"
    const val androidCore = "1.8.0"
    const val androidDatastore = "1.0.0"
    const val androidLifecycle = "2.5.0"
    const val androidPaging = "3.1.1"
    const val androidRoom = "2.4.2"
    const val androidStartup = "1.1.1"
    const val composeBom = "2023.05.01"
    const val desugarJdk = "1.1.5"
    const val kotlinBom = "1.8.20"
    const val kotlinCompilerExtension = "1.4.6"
    const val timber = "5.0.1"

    object Plugins {
        const val agp = "8.0.2"
        const val ksp = "${kotlinBom}-1.0.10"
    }
}

object Deps {
    object Accompanist {
        const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanistPermissions}"
        const val systemUi = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistSystemUi}"
    }

    object Androidx {
        const val core = "androidx.core:core-ktx:${Versions.androidCore}"
        const val datastore = "androidx.datastore:datastore:${Versions.androidDatastore}"
        const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifecycle}"
        const val paging = "androidx.paging:paging-runtime-ktx:${Versions.androidPaging}"
        const val room = "androidx.room:room-ktx:${Versions.androidRoom}"
        const val startup = "androidx.startup:startup-runtime:${Versions.androidStartup}"
    }

    object Compose {
        const val bom = "androidx.compose:compose-bom:${Versions.composeBom}"
        const val compiler = "androidx.compose.compiler:compiler"
        const val foundation = "androidx.compose.foundation:foundation"
        const val material = "androidx.compose.material:material"
        const val runtime = "androidx.compose.runtime:runtime"
        const val ui = "androidx.compose.ui:ui"
        const val uiTooling = "androidx.compose.ui:ui-tooling"
    }

    object Plugins {
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
//        const val kotlinKapt = "kotlin-kapt"
//        const val kotlinSerialization = "plugin.serialization"
//        const val ksp = "com.google.devtools.ksp"
        const val mavenPublish = "maven-publish"
    }

    const val desugarJdk = "com.android.tools:desugar_jdk_libs:${Versions.desugarJdk}"
    const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Versions.kotlinBom}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}
