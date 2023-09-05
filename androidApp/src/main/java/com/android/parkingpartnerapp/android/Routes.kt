package com.android.parkingpartnerapp.android

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object ForgotPassword : Routes("ForgotPassword")
}
