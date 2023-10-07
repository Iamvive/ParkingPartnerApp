package com.appwork.commons.di

import android.content.Context
import androidx.activity.ComponentActivity

object CommonsComponentFactory {
    fun create(
        activity: ComponentActivity,
        context: Context
    ): CommonsComponent =
        DaggerCommonsComponent.factory()
            .create(
                activity = activity,
                context = context,
            )
}
