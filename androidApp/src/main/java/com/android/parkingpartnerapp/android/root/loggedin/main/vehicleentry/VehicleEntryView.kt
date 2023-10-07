package com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.parkingpartnerapp.android.ParkingPartnerAppTheme
import com.android.parkingpartnerapp.android.R
import com.android.parkingpartnerapp.android.R.dimen
import com.android.parkingpartnerapp.android.R.drawable
import com.android.parkingpartnerapp.android.R.string

@Composable
fun VehicleEntryView() {
    VehicleEntryContent()
}

@Composable
fun VehicleEntryContent(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.onSurface)
            .padding(dimensionResource(id = R.dimen.global_8_dp))
    ) {
        RenderVerticalSpacer(dimension = R.dimen.global_60_dp)

        Text(
            text = stringResource(id = string.enter_vehicle_number),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(id = R.dimen.global_8_dp)
                ),
            style = MaterialTheme.typography.headlineMedium,
        )

        RenderVerticalSpacer(dimension = R.dimen.global_48_dp)

        VehicleNumberView()

        RenderVerticalSpacer(dimension = R.dimen.global_48_dp)

        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.global_8_dp)),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = stringResource(id = string.save),
            )
        }

    }
}

@Preview
@Composable
fun VehicleNumberView(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        VehicleSymbol()
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = stringResource(id = R.string.vehicle_number_format))
            }
        )
    }
}

@Preview
@Composable
fun VehicleSymbol(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(
            dimensionResource(id = dimen.global_60_dp),
        )
    ) {
        Image(
            modifier = modifier
                .width(dimensionResource(id = R.dimen.global_40_dp))
                .height(dimensionResource(id = R.dimen.global_40_dp))
                .padding(dimensionResource(id = R.dimen.global_4_dp))
                .clip(CircleShape),
            painter = painterResource(id = drawable.ic_foreground),
            contentDescription = stringResource(id = string.vehicle_img_desc),
        )

        Text(
            text = stringResource(id = R.string.country_abbribriation),
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
fun RenderVerticalSpacer(
    dimension: Int,
    modifier: Modifier = Modifier,
) {
    Spacer(
        modifier = modifier
            .height(dimensionResource(id = dimension))
    )
}

@Preview
@Composable
fun PreviewVehicleEntryView() {
    ParkingPartnerAppTheme {
        VehicleEntryView()
    }
}