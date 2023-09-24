package com.appwork.privacy.permissions.checker

import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.content.ContextCompat
import com.appwork.privacy.permissions.Permissions

class AndroidPermissionChecker(
    private val context: Context,
) : PermissionChecker {
    override suspend fun isGranted(permission: Permissions): Boolean {
        val permissionStatus = ContextCompat.checkSelfPermission(
            context,
            permission.value,
        )
        return permissionStatus.isGranted()
    }

    private fun Int.isGranted(): Boolean = this == PERMISSION_GRANTED
}