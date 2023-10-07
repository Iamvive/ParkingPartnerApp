package com.android.parkingpartnerapp.android.root.loggedin.main.di

import android.content.Context
import com.android.parkingpartnerapp.android.root.loggedin.main.MainActivity
import com.appwork.privacy.permissions.checker.AndroidPermissionChecker
import com.appwork.privacy.permissions.checker.PermissionChecker
import com.appwork.privacy.permissions.rationale.AndroidPermissionRationaleChecker
import com.appwork.privacy.permissions.rationale.PermissionRationaleChecker
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    internal fun providePermissionChecker(
        context: Context,
    ): PermissionChecker = AndroidPermissionChecker(context)

    @Provides
    internal fun providePermissionRationaleChecker(
        activity: MainActivity,
    ): PermissionRationaleChecker = AndroidPermissionRationaleChecker(activity)
}
