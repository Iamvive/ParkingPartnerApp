package com.android.networklibrary.services.loggedin.login

import com.android.networklibrary.services.loggedin.login.data.model.LoginResponse

interface LoginService {
    suspend fun login(mobileNumber: String, password: String): LoginResponse
}
