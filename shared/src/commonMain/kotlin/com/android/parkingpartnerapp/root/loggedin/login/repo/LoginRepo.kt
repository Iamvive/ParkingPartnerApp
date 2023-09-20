package com.android.parkingpartnerapp.root.loggedin.login.repo

import com.android.parkingpartnerapp.repo.Repo
import com.android.parkingpartnerapp.root.loggedin.login.models.ParkingInfoDM

interface LoginRepo : Repo<ParkingInfoDM> {
   suspend fun refresh(mobileNumber: String, password: String)
}