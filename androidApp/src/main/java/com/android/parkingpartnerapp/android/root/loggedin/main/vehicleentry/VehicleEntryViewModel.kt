package com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class VehicleEntryViewModel: ViewModel() {
    private val mutableVehicleNumberStream: MutableStateFlow<String> = MutableStateFlow("")
    val vehicleNumberStream: Flow<String>
        get() = mutableVehicleNumberStream

    fun onVehicleNumberChanged(number: String) {
        mutableVehicleNumberStream.tryEmit(number)
    }

    fun onSaveBtnTapped() {
        println("Save button tapped")
    }
}