package com.android.parkingpartnerapp.android

import com.android.networklibrary.datasource.ParkingPartnerDataSource
import com.android.networklibrary.services.loggedin.login.data.model.Kyc
import com.android.networklibrary.services.loggedin.login.data.model.ParkingInfo
import com.android.parkingpartnerapp.repo.SimpleRepo
import com.android.parkingpartnerapp.root.loggedin.login.models.KycDM
import com.android.parkingpartnerapp.root.loggedin.login.models.ParkingInfoDM
import com.android.parkingpartnerapp.root.loggedin.login.repo.LoginRepo
import javax.inject.Inject

class LoginRepoImpl
@Inject
constructor(
    private val dataSource: ParkingPartnerDataSource,
) : LoginRepo, SimpleRepo<ParkingInfoDM>() {
    override suspend fun refresh(mobileNumber: String, password: String) {
        updateWithValue(
            apiJob = { dataSource.login(mobileNumber, password) },
            mapper = { it.parkingInfo.toDM() }
        )
    }
}

fun Kyc.toDM() = KycDM(
    ownerId = ownerId,
    address = address,
    capacity = capacity,
    city = city,
    gstNo = gstNo,
    pinCode = pinCode,
)

fun ParkingInfo.toDM() = ParkingInfoDM(
    uid = uid,
    email = email,
    mobile = mobile,
    name = name,
    thumbnail = thumbnail,
    kyc = kyc.toDM(),
)