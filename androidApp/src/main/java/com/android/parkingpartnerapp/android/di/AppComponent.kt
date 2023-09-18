package com.android.parkingpartnerapp.android.di

import com.android.networklibrary.di.NetworkComponent
import dagger.Component

@Component(
    modules = [AppModule::class],
    dependencies = [NetworkComponent::class])
interface AppComponent
