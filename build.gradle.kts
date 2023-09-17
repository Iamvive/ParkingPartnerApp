plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt) apply false
}

ext {
    set("versionCode", 1)
    set("versionName", "1.0")
    set("compileSdkVersion", 34)
    set("minSdkVersion", 24)
    set("targetSdkVersion", 33)
    set("nameSpace", "com.android.parkingpartnerapp.android")
    set("kotlinCompilerExtensionVersion", "1.4.7")
    set("jvmTarget", "1.8")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
