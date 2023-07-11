plugins {
    with(Deps.Plugins) {
        id(androidLibrary).version(Versions.Plugins.agp).apply(false)
        id(kotlinAndroid).version(Versions.kotlinBom).apply(false)
//    id(ksp).version(Versions.Plugins.ksp)
//    id(hilt).version(Versions.hilt).apply(false)
//    kotlin(kotlinSerialization).version(Versions.Plugins.kotlin).apply(false)
    }
}
