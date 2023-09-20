package com.android.parkingpartnerapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject lateinit var loginRepo: LoginRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ParkingPartnerApp).appComponent.inject(this)
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

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            loginRepo.refresh("9078606487", "abcd")
            println("LoginData will be : ${loginRepo.lastValue}")
        }
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
