package com.android.parkingpartnerapp.android.di

import android.content.Context
import com.android.parkingpartnerapp.android.LoginRepoImpl
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import com.android.parkingpartnerapp.root.loggedin.login.repo.LoginRepo
import dagger.Module
import dagger.Provides

@Module
 class AppModule(
    private val app: ParkingPartnerApp
) {

    @Provides
    internal fun bindsLoginRepo(imp: LoginRepoImpl): LoginRepo = imp

    @Provides
    internal fun provideApplication(): ParkingPartnerApp = app

    @Provides
    internal fun provideAppContext(): Context = app.applicationContext

}
