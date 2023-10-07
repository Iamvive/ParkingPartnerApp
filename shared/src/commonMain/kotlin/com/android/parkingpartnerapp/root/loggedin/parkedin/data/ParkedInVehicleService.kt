package com.android.parkingpartnerapp.root.loggedin.parkedin.data

import com.android.parkingpartnerapp.root.loggedin.parkedin.data.models.ParkedInVehicleResponse

interface ParkedInVehicleService {
    suspend fun fetchParkedInVehicle(): ParkedInVehicleResponse
}
