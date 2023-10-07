package com.android.parkingpartnerapp.root.loggedin.parkedin.view

import com.android.parkingpartnerapp.root.loggedin.parkedin.view.ParkedInVehicleData

data class ParkedInScreen(
    val screenName: String,
    val parkedInVehicleList: List<ParkedInVehicleData>,
)
