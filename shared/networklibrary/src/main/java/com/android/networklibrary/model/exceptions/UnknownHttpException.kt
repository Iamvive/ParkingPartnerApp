package com.android.networklibrary.model.exceptions

data class UnknownHttpException(
    override val cause: Throwable,
) : Exception(cause)
