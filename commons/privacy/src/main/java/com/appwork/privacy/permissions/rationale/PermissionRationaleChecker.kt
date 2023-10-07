package com.appwork.privacy.permissions.rationale

import com.appwork.privacy.permissions.Permissions

interface PermissionRationaleChecker {
    fun shouldShowPermissionRationale(permission: Permissions): Boolean
}
