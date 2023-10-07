package com.android.parkingpartnerapp.root.loggedin.login.models

data class KycDM(
    val ownerId: String,
    val address: String,
    val capacity: String?,
    val city: String,
    val gstNo: String,
    val pinCode: Int,
)
