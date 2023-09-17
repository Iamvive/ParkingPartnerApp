package com.android.networklibrary.model.exceptions

data class ParsingException(
    override val url : String,
    val statusCode: Int,
    val msg: String,
    override val cause: Throwable,
): NetworkException(url = url, cause = cause)
