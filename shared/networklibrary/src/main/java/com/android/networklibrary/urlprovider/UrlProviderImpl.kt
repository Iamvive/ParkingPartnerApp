package com.android.networklibrary.urlprovider

import com.android.networklibrary.BuildConfig
import javax.inject.Inject

internal class UrlProviderImpl
@Inject
constructor() : UrlProvider {
    private companion object {
        const val BASE_URL_DEBUG = "88.150.180.27:8090"
        const val BASE_URL_PROD = "88.150.180.27:8090" //TODO replace these
    }

    override fun invoke(): String {
        return if (BuildConfig.DEBUG) BASE_URL_DEBUG //TODO replace this with correct info
        else BASE_URL_PROD
    }
}
