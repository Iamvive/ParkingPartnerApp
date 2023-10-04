package com.appwork.commons.di

import android.content.Context
import androidx.activity.ComponentActivity
import com.appwork.privacy.permissions.checker.AndroidPermissionChecker
import com.appwork.privacy.permissions.checker.PermissionChecker
import com.appwork.privacy.permissions.rationale.AndroidPermissionRationaleChecker
import com.appwork.privacy.permissions.rationale.PermissionRationaleChecker
import dagger.Module
import dagger.Provides

@Module
class CommonsModule {

    @Provides
    fun providePermissionChecker(
        context: Context,
    ): PermissionChecker = AndroidPermissionChecker(context)

    @Provides
    fun provideRationaleChecker(
        activity: ComponentActivity,
    ): PermissionRationaleChecker = AndroidPermissionRationaleChecker(activity)
}