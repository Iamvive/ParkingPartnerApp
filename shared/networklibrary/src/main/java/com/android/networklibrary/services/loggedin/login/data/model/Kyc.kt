package com.android.networklibrary.services.loggedin.login.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kyc(
    @SerialName("address")val address: String,
    @SerialName("adhaar")val adhaar: String,
    @SerialName("businessname")val businessName: String,
    @SerialName("capacity")val capacity: String,
    @SerialName("city")val city: String,
    @SerialName("clearances")val clearances: String,
    @SerialName("createBy")val createBy: Int,
    @SerialName("district")val district: String,
    @SerialName("gstNo")val gstNo: String,
    @SerialName("ownerContact")val ownerContact: String,
    @SerialName("ownerEmail")val ownerEmail: String,
    @SerialName("ownerId")val ownerId: String,
    @SerialName("ownerName")val ownerName: String,
    @SerialName("panNo")val panNo: String,
    @SerialName("parkingType")val parkingType: String,
    @SerialName("paymentType")val paymentType: String,
    @SerialName("pincode")val pinCode: Int,
    @SerialName("remark")val remark: String,
    @SerialName("state")val state: String,
    @SerialName("subscriptions")val subscriptions: String,
)