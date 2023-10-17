package com.android.parkingpartnerapp.android.root.loggedin.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import com.android.parkingpartnerapp.android.ParkingPartnerAppTheme
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryComposeView
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var vehicleEntryViewModel: VehicleEntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComp = (application as ParkingPartnerApp).appComponent

        appComp.activityComponentFactory().create(this).inject(this)
        setContent {
            VehicleEntryComposeView(vehicleEntryViewModel)
        }
    }
}

@Preview("Vehicle Entry Screen")
@Composable
fun DefaultPreview() {
    ParkingPartnerAppTheme {
        VehicleEntryComposeView(VehicleEntryViewModel())
    }
}
