package com.android.parkingpartnerapp.android

import android.app.Application
import com.android.networklibrary.di.DaggerNetworkComponent
import com.android.networklibrary.di.NetworkComponent
import com.android.networklibrary.di.NetworkModule
import com.android.parkingpartnerapp.android.di.AppComponent
import com.android.parkingpartnerapp.android.di.AppModule
import com.android.parkingpartnerapp.android.di.DaggerAppComponent

class ParkingPartnerApp : Application() {

    private val networkComponent: NetworkComponent by lazy {
        DaggerNetworkComponent.builder()
            .networkModule(NetworkModule(this.applicationContext))
            .build()
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .networkComponent(networkComponent)
            .appModule(AppModule(this))
            .build()
    }
}
