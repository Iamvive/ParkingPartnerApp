package com.android.parkingpartnerapp.android.root.loggedin.main.di


import com.android.parkingpartnerapp.android.root.loggedin.main.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [ActivityModule::class],
)
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance activity: MainActivity): ActivityComponent
    }
    fun inject(activity: MainActivity)
}