package com.android.networklibrary.services.loggedin.login.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("data") val parkingInfo: ParkingInfo,
    @SerialName("message") val message: String,
    @SerialName("status") val statusCode: Int
)