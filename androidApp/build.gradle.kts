plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
}

android {
    namespace = rootProject.ext["nameSpace"] as String
    compileSdk = rootProject.ext["compileSdkVersion"] as Int
    defaultConfig {
        applicationId = rootProject.ext["nameSpace"] as String
        minSdk = rootProject.ext["minSdkVersion"] as Int
        targetSdk = rootProject.ext["targetSdkVersion"] as Int
        versionCode = rootProject.ext["versionCode"] as Int
        versionName = rootProject.ext["versionName"] as String
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.ext["kotlinCompilerExtensionVersion"] as String
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = rootProject.ext["jvmTarget"] as String
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.material.icons.extended)
    implementation (platform(libs.androidx.compose.bom))
}