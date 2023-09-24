package com.appwork.commons.di

import androidx.activity.ComponentActivity
import com.appwork.privacy.permissions.checker.PermissionChecker
import com.appwork.privacy.permissions.rationale.PermissionRationaleChecker
import dagger.Component

@Component(modules = [CommonsModule::class])
interface CommonsComponent {
    @Component.Builder
    interface Builder {
        fun commonsModule(module: CommonsModule): Builder
        fun build(): CommonsComponent
    }

    fun providePermissionChecker(): PermissionChecker
    fun injectActivity(activity: ComponentActivity)
}