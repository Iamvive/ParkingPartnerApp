package com.appwork.privacy.permissions.rationale

import androidx.core.app.ActivityCompat
import androidx.core.app.ComponentActivity
import com.appwork.privacy.permissions.Permissions

class AndroidPermissionRationaleChecker(
    private val activity: ComponentActivity,
) : PermissionRationaleChecker {
    override fun shouldShowPermissionRationale(permission: Permissions): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission.value)
    }
}
