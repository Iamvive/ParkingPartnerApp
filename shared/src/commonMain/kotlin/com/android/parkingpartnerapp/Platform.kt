package com.android.parkingpartnerapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform