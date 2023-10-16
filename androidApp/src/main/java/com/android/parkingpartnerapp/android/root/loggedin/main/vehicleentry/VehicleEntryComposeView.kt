package com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.android.parkingpartnerapp.android.R.string

@Composable
fun VehicleEntryComposeView(
    vehicleEntryViewModel: VehicleEntryViewModel
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (enterVehicleTV, vehicleNumberContainer, doneBtn, divider, otherInfoTV) = createRefs()

        Text(
            modifier = Modifier
                .fillMaxWidth(1f)
                .constrainAs(enterVehicleTV) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            text = stringResource(id = string.enter_vehicle_number),
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
        )

        Divider(
            modifier = Modifier.height(2.dp)
                .constrainAs(divider) {
                    bottom.linkTo(otherInfoTV.top)
                }
        )

        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(1f)
                .constrainAs(otherInfoTV) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            text = stringResource(id = string.parking_vehicle_info),
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun RenderVerticalSpacer(
    dimension: Dp,
    modifier: Modifier = Modifier,
) {
    Spacer(
        modifier = modifier
            .height(dimension)
    )
}