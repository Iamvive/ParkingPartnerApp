package com.android.networklibrary.di

import android.content.Context
import com.android.networklibrary.ktor.KtorClient
import com.android.networklibrary.urlprovider.UrlProvider
import com.android.networklibrary.urlprovider.UrlProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    internal abstract fun bindUrlProvider(imp: UrlProviderImpl): UrlProvider

    companion object {
        @Provides
        fun provideClient(
            context: Context,
            urlProvider: UrlProvider,
        ): HttpClient = KtorClient(context, urlProvider).client
    }

}
