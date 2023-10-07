package com.android.networklibrary.services.loggedin.login.data.http

import com.android.networklibrary.ktor.httpCall
import com.android.networklibrary.model.exceptions.ApiException
import com.android.networklibrary.serde.JsonProvider.json
import com.android.networklibrary.serde.httpDeserialize
import com.android.networklibrary.services.loggedin.login.LoginService
import com.android.networklibrary.services.loggedin.login.data.model.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import javax.inject.Inject

internal class HttpLoginService
@Inject
constructor(
    private val httpClient: HttpClient,
) : LoginService {
    override suspend fun login(mobileNumber: String, password: String): LoginResponse {
        return httpCall {
            httpClient.get {
                url { path("api", "getLogin") }
                parameter("mobile", mobileNumber)
                parameter("password", password)
            }.httpDeserialize(
                json,
                LoginResponse.serializer(),
                ApiException.serializer()
            )
        }
    }
}
