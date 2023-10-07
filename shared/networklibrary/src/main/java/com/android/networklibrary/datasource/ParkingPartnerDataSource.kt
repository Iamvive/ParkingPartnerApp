package com.android.networklibrary.datasource

import com.android.networklibrary.services.loggedin.login.LoginService
import com.android.networklibrary.services.loggedin.login.data.model.LoginResponse
import javax.inject.Inject

class ParkingPartnerDataSource
@Inject
constructor(
    private val loginService: LoginService,
) {
    suspend fun login(mobileNumber: String, password: String): LoginResponse {
        return loginService.login(mobileNumber, password)
    }
}
