package com.android.parkingpartnerapp.android.root.loggedin.main.vehicleentry

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.android.parkingpartnerapp.android.R.drawable
import com.android.parkingpartnerapp.android.R.string

@Composable
fun VehicleEntryComposeView(
    vehicleEntryViewModel: VehicleEntryViewModel,
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        val vehicleNumber: String =
            vehicleEntryViewModel.vehicleNumberStream.collectAsState("").value
                .let {
                    println("This is the value of vehicle number entered $it")
                    it
                }
        val (enterVehicleTV, vehicleNumberContainer, doneBtn, dividerBottom, otherInfoTV) = createRefs()
        Text(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(vertical = 60.dp)
                .constrainAs(enterVehicleTV) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            text = stringResource(id = string.enter_vehicle_number),
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(vehicleNumberContainer) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(enterVehicleTV.bottom)
                },
        ) {
            val (numberPlateSymbolContainer, vehicleNumberTF) = createRefs()

            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.15f)
                    .constrainAs(numberPlateSymbolContainer) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    },
                shape = CutCornerShape(topStart = 4.dp, bottomStart = 4.dp),
                color = Color.Blue,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Image(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .width(24.dp)
                            .height(24.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = drawable.ic_foreground),
                        contentDescription = stringResource(id = string.vehicle_img_desc),
                        contentScale = ContentScale.Inside,
                    )

                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = stringResource(id = string.country_iso_code),
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }

            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .constrainAs(vehicleNumberTF) {
                        start.linkTo(numberPlateSymbolContainer.end)
                        top.linkTo(numberPlateSymbolContainer.top)
                        bottom.linkTo(numberPlateSymbolContainer.bottom)
                        end.linkTo(parent.end)
                    },
                shape = CutCornerShape(topEnd = 4.dp, bottomEnd = 4.dp),
                value = vehicleNumber,
                onValueChange = {
                    if (it.length > 10) return@TextField
                    vehicleEntryViewModel.onVehicleNumberChanged(it)
                },
                label = {
                    Text(text = stringResource(id = string.vehicle_number_format))
                },
                keyboardOptions = KeyboardOptions(
                    KeyboardCapitalization.Characters,
                    keyboardType = KeyboardType.Text,
                ),
                singleLine = true,
            ) //TODO height not matching with numberplate container
        }

        OutlinedButton(
            modifier = Modifier
                .padding(vertical = 60.dp)
                .fillMaxWidth()
                .constrainAs(doneBtn) {
                    start.linkTo(parent.start)
                    top.linkTo(vehicleNumberContainer.bottom)
                    end.linkTo(parent.end)
                },
            onClick = { vehicleEntryViewModel.onSaveBtnTapped() },
            enabled = vehicleNumber.length >= 10,
            shape = CutCornerShape(2.dp),
        ) {
            Text(
                text = stringResource(id = string.save),
                color = Color.White,
            )
        } //TODO Button state is not properly visible

        Divider(
            modifier = Modifier
                .height(2.dp)
                .constrainAs(dividerBottom) {
                    bottom.linkTo(otherInfoTV.top)
                }
        )

        Text(
            modifier = Modifier
                .padding(8.dp)
                .constrainAs(otherInfoTV) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
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