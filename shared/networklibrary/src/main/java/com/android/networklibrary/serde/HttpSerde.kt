package com.android.networklibrary.serde

import com.android.networklibrary.model.exceptions.DomainException
import com.android.networklibrary.model.exceptions.ParsingException
import com.android.networklibrary.model.exceptions.ServerException
import com.android.networklibrary.model.exceptions.StrategyFailureException
import com.android.networklibrary.model.exceptions.UnknownException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json

fun <Request : Any> Request.httpSerialize(
    json: Json,
    strategy: SerializationStrategy<Request>,
): TextContent = TextContent(
    text = json.encodeToString(strategy, this),
    contentType = ContentType.Application.Json
)

suspend fun <Success, Failure : Exception> HttpResponse.httpDeserialize(
    json: Json,
    successStrategy: DeserializationStrategy<Success>,
    failureStrategy: DeserializationStrategy<Failure>? = null,
): Success {
    val statusCode = status.value
    val text = bodyAsText()

    val url = call.request.url.toString()

    return when (statusCode) {
        in 200..299 -> deserializeSuccess(url, json, statusCode, successStrategy, text)
        in 400..499 -> throw deserializeFailure(url, json, statusCode, failureStrategy, text)
        in 500..599 -> throw ServerException(url, statusCode, text, Throwable("Server Exception"))
        else -> throw UnknownException(url, statusCode, text)
    }
}

private fun <Success> deserializeSuccess(
    url: String,
    json: Json,
    statusCode: Int,
    strategy: DeserializationStrategy<Success>,
    jsonResponseString: String,
): Success = try {
    json.decodeFromString(strategy, jsonResponseString)
} catch (e: Exception) {
    throw ParsingException(url, statusCode, jsonResponseString, e)
}

private fun <Failure : Exception> deserializeFailure(
    url: String,
    json: Json,
    statusCode: Int,
    strategy: DeserializationStrategy<Failure>?,
    jsonResponseString: String,
): Exception {
    if (strategy == null) throw StrategyFailureException(url, Throwable("Failure Strategy is null"))

    return try {
        val failure = json.decodeFromString(strategy, jsonResponseString)
        DomainException(url, failure)
    } catch (e: Exception) {
        ParsingException(url, statusCode, jsonResponseString, e)
    }
}
