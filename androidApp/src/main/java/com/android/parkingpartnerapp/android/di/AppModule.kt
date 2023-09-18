package com.android.parkingpartnerapp.android.di

import android.content.Context
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {
        @Singleton
        @Provides
        internal fun provideApplication(app: ParkingPartnerApp): ParkingPartnerApp = app

        @Singleton
        @Provides
        internal fun provideAppContext(app: ParkingPartnerApp): Context = app.applicationContext
    }
}
