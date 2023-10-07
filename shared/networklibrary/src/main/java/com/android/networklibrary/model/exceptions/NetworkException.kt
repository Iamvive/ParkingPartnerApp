package com.android.networklibrary.model.exceptions

sealed class NetworkException(
    open val url: String,
    val errorMsg: String? = null,
    override val cause: Throwable? = null,
) : Exception(cause)
