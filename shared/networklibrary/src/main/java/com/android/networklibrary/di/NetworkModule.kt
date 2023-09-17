package com.android.networklibrary.di

import android.content.Context
import com.android.networklibrary.ktor.KtorClient
import com.android.networklibrary.urlprovider.UrlProvider
import com.android.networklibrary.urlprovider.UrlProviderImpl
import dagger.Module
import dagger.Provides
import io.ktor.client.*

@Module
class NetworkModule(
    private val context: Context,
) {

    @Provides
    fun provideBaseUrl(): UrlProvider = UrlProviderImpl()

    @Provides
    fun provideClient(urlProvider: UrlProvider): HttpClient =
        KtorClient(context, urlProvider).client
}
