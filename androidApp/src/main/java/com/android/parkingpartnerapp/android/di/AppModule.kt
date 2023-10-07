package com.android.parkingpartnerapp.android.di

import android.content.Context
import com.android.parkingpartnerapp.android.LoginRepoImpl
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import com.android.parkingpartnerapp.root.loggedin.login.repo.LoginRepo
import com.appwork.privacy.permissions.checker.AndroidPermissionChecker
import com.appwork.privacy.permissions.checker.PermissionChecker
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val application: ParkingPartnerApp,
) {

    @Provides
    internal fun bindsLoginRepo(imp: LoginRepoImpl): LoginRepo = imp

    @Provides
    internal fun provideApplication(
    ): ParkingPartnerApp = application

    @Provides
    internal fun provideAppContext(): Context = application.applicationContext
}
