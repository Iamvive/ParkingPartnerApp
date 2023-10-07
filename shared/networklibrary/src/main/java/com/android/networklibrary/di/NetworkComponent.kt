package com.android.networklibrary.di

import com.android.networklibrary.datasource.ParkingPartnerDataSource
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    @Component.Builder
    interface Builder {
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): NetworkComponent
    }
    fun dataSource(): ParkingPartnerDataSource
}
