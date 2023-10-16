package com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.parkingpartnerapp.android.R
import com.android.parkingpartnerapp.android.R.drawable
import com.android.parkingpartnerapp.android.R.string

@Composable
fun VehicleEntryView(vehicleEntryViewModel: VehicleEntryViewModel) {
    VehicleEntryContent(vehicleEntryViewModel = vehicleEntryViewModel)
}

@Composable
fun VehicleEntryContent(
    modifier: Modifier = Modifier,
    vehicleEntryViewModel: VehicleEntryViewModel,
) {
    val vehicleNumber: String = vehicleEntryViewModel.vehicleNumberStream.collectAsState("").value
        .let {
            println("This is the value of vehicle number entered $it")
            it
        }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(16.dp)
    ) {
        RenderVerticalSpacer(dimension = 60.dp)

        Text(
            text = stringResource(id = string.enter_vehicle_number),
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(),
            style = MaterialTheme.typography.headlineMedium,
        )

        RenderVerticalSpacer(48.dp)

        VehicleNumberView(
            viewModel = vehicleEntryViewModel,
            vehicleNumber = vehicleNumber,
        )

        RenderVerticalSpacer(dimension = 48.dp)

        OutlinedButton(
            modifier = modifier
                .fillMaxWidth(),
            onClick = { vehicleEntryViewModel.onSaveBtnTapped() },
            enabled = vehicleNumber.length >= 10,
        ) {
            Text(
                text = stringResource(id = string.save),
            )
        }

    }
}

@Composable
fun VehicleNumberView(
    modifier: Modifier = Modifier,
    viewModel: VehicleEntryViewModel,
    vehicleNumber: String,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .wrapContentHeight(Alignment.Top)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Blue),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            VehicleSymbol()
            TextField(
                modifier = modifier
                    .fillMaxWidth(0.85f)
                    .weight(0.85f),
                value = vehicleNumber,
                onValueChange = {
                    if (it.length > 10) return@TextField
                    viewModel.onVehicleNumberChanged(it)
                },
                label = {
                    Text(text = stringResource(id = R.string.vehicle_number_format))
                },
                keyboardOptions = KeyboardOptions(
                    KeyboardCapitalization.Characters,
                    keyboardType = KeyboardType.Text,
                ),
                singleLine = true,
            )
        }
    }
}

@Composable
fun VehicleSymbol(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth(0.15f),
    ) {
        Image(
            modifier = modifier
                .width(24.dp)
                .height(24.dp)
                .clip(CircleShape),
            painter = painterResource(id = drawable.ic_foreground),
            contentDescription = stringResource(id = string.vehicle_img_desc),
            contentScale = ContentScale.Inside,
        )

        Text(
            text = stringResource(id = R.string.country_iso_code),
            color = Color.White,
        )
    }
}
