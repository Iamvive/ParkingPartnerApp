package com.android.parkingpartnerapp.android.di

import com.android.networklibrary.di.NetworkComponent
import com.android.parkingpartnerapp.android.MainActivity
import com.appwork.commons.di.CommonsComponent
import dagger.Component

@Component(
    modules = [AppModule::class],
    dependencies = [NetworkComponent::class],
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun networkComponent(component: NetworkComponent): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
    fun inject(activity: MainActivity)
}
