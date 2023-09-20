package com.android.networklibrary.services.loggedin.login.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParkingInfo(
    @SerialName("uid")val uid: Int,
    @SerialName("designation")val designation: String,
    @SerialName("email")val email: String,
    @SerialName("fpath")val thumbnail: String,
    @SerialName("kyc")val kyc: Kyc,
    @SerialName("mobile")val mobile: String,
    @SerialName("name")val name: String,
    @SerialName("roleid")val roleId: Int,
)