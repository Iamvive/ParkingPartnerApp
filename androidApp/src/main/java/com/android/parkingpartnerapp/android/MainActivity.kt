package com.android.parkingpartnerapp.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.android.parkingpartnerapp.Greeting
import com.android.parkingpartnerapp.root.loggedin.login.repo.LoginRepo
import com.appwork.privacy.permissions.Permissions
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginRepo: LoginRepo

    private val requestPermissionLauncher =
        registerForActivityResult(
            RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Log.i("Permission: ", "Granted")
            } else {
                Log.i("Permission: ", "Denied")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as ParkingPartnerApp).appComponent
            .inject(this)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }

    private suspend fun onClickRequestPermission() {
//        when {
//            permissionGranted() -> println("Permission Granted")
//            shouldShowRationale() -> launchRequest() //TODO Show an educative screen then on tap of this show launchRequest
//            else -> launchRequest()
//        }
    }

    private fun launchRequest() {
        requestPermissionLauncher.launch(Permissions.CAMERA.value)
    }

//    private fun shouldShowRationale() =
//        permissionRationale.shouldShowPermissionRationale(Permissions.CAMERA)
//
//    private suspend fun permissionGranted() =
//        permissionChecker.isGranted(Permissions.CAMERA)

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            loginRepo.refresh("9078606487", "abcd")
            println("LoginData will be : ${loginRepo.lastValue}")
        }

        lifecycleScope.launch { onClickRequestPermission() }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(dimensionResource(R.dimen.global_14_dp)),
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView(stringResource(R.string.hello_android))
    }
}
