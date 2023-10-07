package com.android.networklibrary.ktor

import android.content.Context
import com.android.networklibrary.urlprovider.UrlProvider
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

class KtorClient
constructor(
    private val context: Context,
    private val urlProvider: UrlProvider,
) {
    val client: HttpClient =
        HttpClient(OkHttp) {
            initDefaultConfigs(urlProvider)

            engine {
                addInterceptor(ChuckerInterceptor.Builder(context).build())
            }

            install(HttpTimeout) {
                requestTimeoutMillis = TIME_OUT
                connectTimeoutMillis = TIME_OUT
                socketTimeoutMillis = TIME_OUT
            }

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.BODY //or ALL
                level = LogLevel.ALL
            }

        }

    companion object {
        const val TIME_OUT = 5000L
    }
}
