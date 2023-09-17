package com.android.networklibrary.ktor

import com.android.networklibrary.model.exceptions.DomainException
import com.android.networklibrary.model.exceptions.NetworkException
import com.android.networklibrary.model.exceptions.ParsingException
import com.android.networklibrary.model.exceptions.ServerException
import com.android.networklibrary.model.exceptions.StrategyFailureException
import com.android.networklibrary.model.exceptions.UnknownException
import com.android.networklibrary.model.exceptions.UnknownHttpException

suspend fun <Success> httpCall(
    job: suspend () -> Success,
): Success =
    try {
        job.invoke()
    } catch (e: Exception) {
        when (e) {
            is NetworkException -> handleNetworkException(e)
            else -> throw UnknownHttpException(e)
        }
    }

fun handleNetworkException(e: NetworkException): Nothing =
    when (e) {
        is DomainException -> {
            println("API failure with url: ${e.url}") //TODO remove or config these log for debug only
            throw e.cause
        }
        is ParsingException -> {
            println("API failure $e with url: ${e.url} with code: ${e.statusCode}")
            throw e
        }
        is ServerException -> {
            println("API failure $e with url: ${e.url} with code: ${e.statusCode}")
            throw e
        }
        is StrategyFailureException -> {
            println("API failure $e with url: ${e.url} with code: ${e.cause}")
            throw e
        }
        is UnknownException -> {
            println("API failure $e with url: ${e.url} with code: ${e.msg}")
            throw e
        }
    }

