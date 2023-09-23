package com.android.parkingpartnerapp.android.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.parkingpartnerapp.android.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }

            }
        }
    }

    @Preview
    @Composable
    fun LoginScreen(){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
                    .padding(8.dp)
            ) {
                HeaderView()
            }

            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .padding(8.dp)
            ) {
                AppLogo()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .padding(8.dp)
            ) {
                LoginCardView()
            }
        }
    }


    @Preview
    @Composable
    fun HeaderView() {
        Text(
            text = "App Name",
            fontSize = 36.sp,
            modifier = Modifier
                .padding(12.dp),
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Monospace,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }

    @Preview
    @Composable
    fun AppLogo() {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            painter = painterResource(R.drawable.ic_parking),
            contentDescription = stringResource(R.string.description)
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun LoginCardView() {
        val inputvalue = remember { mutableStateOf(TextFieldValue()) }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                value = inputvalue.value,
                onValueChange = { inputvalue.value = it },
                label = { Text(text = "Enter user name") },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif
                ),
            )

            TextField(
                value = inputvalue.value,
                onValueChange = { inputvalue.value = it },
                label = { Text(text = "Enter password") },
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif
                ),
            )

            Button(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(12.dp),

            ) {
                Text(text = "Login")
            }
        }
    }
}