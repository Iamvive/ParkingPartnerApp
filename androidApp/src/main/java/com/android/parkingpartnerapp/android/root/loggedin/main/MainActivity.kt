package com.android.parkingpartnerapp.android.root.loggedin.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.android.parkingpartnerapp.android.ParkingPartnerAppTheme
import com.android.parkingpartnerapp.android.ParkingPartnerApp
import com.android.parkingpartnerapp.android.R.dimen
import com.android.parkingpartnerapp.android.R.string
import com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry.VehicleEntryView
import com.android.parkingpartnerapp.root.loggedin.login.repo.LoginRepo
import com.appwork.privacy.permissions.Permissions
import com.appwork.privacy.permissions.checker.PermissionChecker
import com.appwork.privacy.permissions.rationale.PermissionRationaleChecker
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginRepo: LoginRepo

    @Inject
    lateinit var permissionChecker: PermissionChecker

    @Inject
    lateinit var permissionRationaleChecker: PermissionRationaleChecker

    private val requestPermissionLauncher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            /* contract = */ RequestMultiplePermissions()
        ) {
            println(message = "Permission requested is: $it")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComp = (application as ParkingPartnerApp).appComponent

        appComp.activityComponentFactory().create(this).inject(this)
        lifecycleScope.launch { onClickRequestPermission() }
        setContent {
            ParkingPartnerAppTheme {
                VehicleEntryView()
            }
        }
    }

    private suspend fun onClickRequestPermission() {
        when {
            permissionGranted() -> println("Permission Granted")
            shouldShowRationale() -> launchRequest() //TODO Show an educative screen then on tap of this show launchRequest
            else -> launchRequest()
        }
    }

    private fun launchRequest() {
        requestPermissionLauncher.launch(
            arrayOf(
                Permissions.CAMERA.value,
            )
        )
    }

    private fun shouldShowRationale() =
        permissionRationaleChecker.shouldShowPermissionRationale(Permissions.CAMERA)

    private suspend fun permissionGranted() =
        permissionChecker.isGranted(Permissions.CAMERA)

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            loginRepo.refresh("9078606487", "abcd")
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(dimensionResource(dimen.global_14_dp)),
    )
}

@Preview
@Composable
fun DefaultPreview() {
    ParkingPartnerAppTheme {
        GreetingView(stringResource(string.hello_android))
    }
}
