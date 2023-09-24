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
class CommonsModule(
    private val context: Context,
    private val activity: ComponentActivity,
) {
    @Provides
    fun provideActivity() : ComponentActivity = activity

    @Provides
    fun providePermissionChecker(): PermissionChecker =
        AndroidPermissionChecker(context)

    @Provides
    fun provideRationaleChecker(
        activity: ComponentActivity,
    ): PermissionRationaleChecker =
        AndroidPermissionRationaleChecker(activity)
}