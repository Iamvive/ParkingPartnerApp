package com.android.parkingpartnerapp.root.loggedin.login.models

data class ParkingInfoDM(
    val uid: Int,
    val email: String,
    val mobile: String,
    val name: String,
    val thumbnail: String,
    val kyc: KycDM,
)
