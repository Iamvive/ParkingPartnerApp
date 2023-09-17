package com.android.networklibrary.urlprovider


class UrlProviderImpl : UrlProvider {
    private companion object {
        const val BASE_URL_DEBUG = "jsonplaceholder.typicode.com"
        const val BASE_URL_PROD = "jsonplaceholder.typicode.com" //TODO replace these
    }

    override fun invoke(): String =
        if (true) BASE_URL_DEBUG //TODO replace this with correct info
        else BASE_URL_PROD
}
