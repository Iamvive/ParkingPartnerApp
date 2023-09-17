package com.android.parkingpartnerapp.android.di

import android.content.Context
import com.android.networklibrary.di.NetworkComponent
import com.android.networklibrary.di.NetworkModule
import com.android.parkingpartnerapp.android.MainActivity
import dagger.Component

@Component(
    modules = [AppModule::class],
    dependencies = [NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun networkComponent(component: NetworkComponent): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    fun injectActivity(activity: MainActivity)

    fun provideAppContext(): Context
}