package com.android.networklibrary.model.exceptions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.Exception

@Serializable
data class ApiException(
    @SerialName("error_code")
    val errorCode: Int,
    @SerialName("error_message")
    val errorMessage: String,
) : Exception(errorMessage)
