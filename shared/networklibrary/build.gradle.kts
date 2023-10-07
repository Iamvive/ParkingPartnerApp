plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    kotlin("kapt")
}

android {
    namespace = "com.android.networklibrary"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val ktorVersion = "2.0.0"
    val chuckerVersion = "3.5.2"
    //Ktor android client
    implementation ("io.ktor:ktor-client-core:$ktorVersion")
    implementation ("io.ktor:ktor-client-android:$ktorVersion")
    implementation ("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation ("io.ktor:ktor-client-logging-jvm:$ktorVersion")

    //Serialization
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    //Interceptor
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")

    debugImplementation("com.github.chuckerteam.chucker:library:$chuckerVersion")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:$chuckerVersion")

    implementation(libs.hilt.android)
    kapt(libs.hilt.ext.compiler)

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}