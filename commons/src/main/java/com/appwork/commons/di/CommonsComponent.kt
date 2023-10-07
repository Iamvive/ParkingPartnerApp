package com.appwork.commons.di

import android.content.Context
import androidx.activity.ComponentActivity
import com.appwork.privacy.permissions.checker.PermissionChecker
import com.appwork.privacy.permissions.rationale.PermissionRationaleChecker
import dagger.BindsInstance
import dagger.Component

@Component(modules = [CommonsModule::class])
interface CommonsComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: ComponentActivity,
            @BindsInstance context: Context,
        ): CommonsComponent
    }

    val permissionChecker: PermissionChecker
    val rationaleChecker: PermissionRationaleChecker
}
