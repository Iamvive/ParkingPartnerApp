package com.android.networklibrary.model.exceptions

data class UnknownException(
    override val url: String,
    val statusCode: Int,
    val msg: String
) : NetworkException(url = url)
