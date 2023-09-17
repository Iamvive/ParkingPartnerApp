package com.android.parkingpartnerapp.root.loggedin.parkedin.repo

import com.android.parkingpartnerapp.root.loggedin.parkedin.view.ParkedInVehicleData

interface ParkedInVehicleRepo {
    suspend fun fetchParkedInVehicles(): List<ParkedInVehicleData>
}