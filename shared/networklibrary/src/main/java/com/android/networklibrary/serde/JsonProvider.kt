package com.android.networklibrary.serde

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus

object JsonProvider {
    fun invoke(modules: List<SerializersModule>): Json =
        Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            isLenient = false
            coerceInputValues = true
            allowSpecialFloatingPointValues = false
            serializersModule =
                modules.fold(EmptySerializersModule, SerializersModule::plus)
        }

    val json: Json = invoke(emptyList())
}
