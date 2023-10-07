package com.android.networklibrary.ktor

import com.android.networklibrary.urlprovider.UrlProvider
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.*

fun <T: HttpClientEngineConfig> HttpClientConfig<T>.initDefaultConfigs(
    urlProvider: UrlProvider,
)
{
    defaultRequest {
        url {
          protocol = URLProtocol.HTTP
          host = urlProvider()
        }
    }

    //HERE ADD HEADERS AS WELL
}
