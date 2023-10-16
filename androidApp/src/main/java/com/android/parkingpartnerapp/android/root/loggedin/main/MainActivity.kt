package com.android.parkingpartnerapp.android.root.loggedin.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import com.android.parkingpartnerapp.android.ParkingPartnerAppTheme
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryComposeView
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryView
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryViewModel

class MainActivity : ComponentActivity() {
    private val vehicleEntryViewModel by viewModels<VehicleEntryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComp = (application as ParkingPartnerApp).appComponent

        appComp.activityComponentFactory().create(this).inject(this)
        setContent {
            ParkingPartnerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onSurface,
                ) {
                    VehicleEntryComposeView(vehicleEntryViewModel)
                }

            }
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
