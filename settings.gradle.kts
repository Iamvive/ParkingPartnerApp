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
    versionCatalogs {
        create("libs") {
            from(files("./gradle/libs.version.toml"))
        }
    }
}

rootProject.name = "ParkingPartnerApp"
include(":androidApp")
include(":shared")
//Below code is responsible for including the KMM lib to ParkingPartnerApp
//includeBuild("../KMM-Lib")
include(":shared:networklibrary")
