pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ParkingPartnerApp"
include(":androidApp")
include(":shared")
//Below code is responsible for including the KMM lib to ParkingPartnerApp
includeBuild("../KMM-Lib")