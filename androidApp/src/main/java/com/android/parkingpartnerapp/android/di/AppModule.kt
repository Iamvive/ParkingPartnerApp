package com.android.parkingpartnerapp.android.di

import android.content.Context
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule(
    private val app: ParkingPartnerApp,
) {

    @Singleton
    @Provides
    fun provideApplication(app: ParkingPartnerApp) : ParkingPartnerApp = app

    @Singleton
    @Provides
    fun provideAppContext(app:ParkingPartnerApp): Context = app.applicationContext
}