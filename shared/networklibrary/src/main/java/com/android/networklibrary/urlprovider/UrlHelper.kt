package com.android.networklibrary.urlprovider

interface UrlProvider {
    operator fun invoke(): String
}
