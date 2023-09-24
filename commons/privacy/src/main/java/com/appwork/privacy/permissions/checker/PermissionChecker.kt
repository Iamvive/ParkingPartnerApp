package com.appwork.privacy.permissions.checker

import com.appwork.privacy.permissions.Permissions

interface PermissionChecker {
    suspend fun isGranted(permission: Permissions): Boolean
}