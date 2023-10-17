package com.android.parkingpartnerapp.android.root.loggedin.main.di

import android.content.Context
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.android.parkingpartnerapp.android.root.loggedin.main.MainActivity
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryViewModel
import com.appwork.privacy.permissions.checker.AndroidPermissionChecker
import com.appwork.privacy.permissions.checker.PermissionChecker
import com.appwork.privacy.permissions.rationale.AndroidPermissionRationaleChecker
import com.appwork.privacy.permissions.rationale.PermissionRationaleChecker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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

    @ActivityScope
    @Provides
    internal fun vehicleEntryViewModel(): VehicleEntryViewModel = VehicleEntryViewModel()
}
