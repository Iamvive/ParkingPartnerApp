package com.android.networklibrary.di

import android.content.Context
import com.android.networklibrary.ktor.KtorClient
import com.android.networklibrary.services.loggedin.login.LoginService
import com.android.networklibrary.services.loggedin.login.data.http.HttpLoginService
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
    internal fun bindUrlProvider(imp: UrlProviderImpl): UrlProvider = imp

    @Provides
    internal fun bindLoginService(imp: HttpLoginService): LoginService = imp

    @Provides
    fun provideClient(
        urlProvider: UrlProvider,
    ): HttpClient = KtorClient(context, urlProvider).client
}
