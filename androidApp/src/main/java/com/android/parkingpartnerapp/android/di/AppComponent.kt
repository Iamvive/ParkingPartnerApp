package com.android.parkingpartnerapp.android.di

import com.android.networklibrary.di.NetworkComponent
import com.android.parkingpartnerapp.android.root.loggedin.main.MainActivity
import com.android.parkingpartnerapp.android.root.loggedin.main.di.ActivityComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
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

    fun activityComponentFactory(): ActivityComponent.Factory
}
