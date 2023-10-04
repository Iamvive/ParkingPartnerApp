package com.android.parkingpartnerapp.android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ParkedInListActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          ParkedInListActivity(createVehicleList())
        }
      }
    }
  }

  data class Vehicle(
    val profileName : String,
    val text: String,
    val checkTime: String,
    val amount: Double
  )

  private fun createVehicleList(): List<Vehicle> {
    return listOf(
      Vehicle("UP","UP85AB1234", "09:45AM", 120.00),
      Vehicle("OD","OD85AB1234", "09:45AM", 240.00),
      Vehicle("AP","AP85AB1234", "09:45AM", 40.00),
      Vehicle("WB","WB85AB1234", "09:45AM", 80.00),
      Vehicle("DL","DL85AB1234", "09:45AM", 200.00),
      Vehicle("KA","KA85AB1234", "09:45AM", 120.00),
      Vehicle("KL","KL85AB1234", "09:45AM", 200.00),
      Vehicle("MH","MH85AB1234", "09:45AM", 200.00),
      Vehicle("AP","AP85AB1234", "09:45AM", 40.00),
      Vehicle("WB","WB85AB1234", "09:45AM", 80.00),
      Vehicle("DL","DL85AB1234", "09:45AM", 200.00),

      )
  }

  @Composable
  fun ParkedInListActivity(vehicleList: List<Vehicle>) {
    val mCheckedState = remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
      ParkedInAppBar()
      LazyColumn(Modifier.weight(2f)) {
        items(vehicleList) { item ->
          // specifies text & divider for each item
          VehicleItemView(item)
          Divider()
        }
      }
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @Preview
  @Composable
  fun ParkedInAppBar(){
    Surface (
      color =  MaterialTheme.colorScheme.secondary,
      shadowElevation = 4.dp
    ){
      TopAppBar(
        modifier = Modifier.background(color = Color.Blue),
        title = { Text(text = "Parked-in", fontWeight = FontWeight.Bold) },
        navigationIcon = { IconButton(onClick = { }) { Icon(Icons.Filled.ArrowBack, "") } },
        actions = {}
      )
    }
  }

  @Preview
  @Composable
  fun VehicleItemView(
    vehicle: Vehicle = Vehicle(
      "UP",
      "UP85AB1234",
      "09:45SAM",
      120.00
    )
  ) {
    Surface(
      color = Color.Transparent,
      tonalElevation = 40.dp,
      shape = RoundedCornerShape(8.dp),
      modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
    ) {
      Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        horizontalArrangement= Arrangement.SpaceAround
        ) {
        Surface( modifier = Modifier
          .padding(4.dp),shape = CircleShape, color = Color.LightGray) {
          Text(
            modifier = Modifier
              .padding(4.dp)
              .clip(RoundedCornerShape(20.dp)),
            text = vehicle.profileName,
            fontSize = 24.sp,
            color = Color.DarkGray,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
          )
        }

        Column( modifier = Modifier.padding(horizontal = 2.dp)
        ) {
          Text(
            text = vehicle.text, fontSize = 20.sp, color = Color.Black,
            fontStyle = FontStyle.Normal, fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
          )
          Row() {
            Text(
              text = "Check-in Time : ",
              fontSize = 12.sp,
              color = Color.DarkGray,
              fontStyle = FontStyle.Normal,
              fontFamily = FontFamily.SansSerif,
            )
            Text(
              text = vehicle.checkTime, fontSize = 12.sp,
              fontStyle = FontStyle.Normal, fontFamily = FontFamily.Monospace,
            )
          }
        }

        Text(
          text = "₹"+ vehicle.amount.toString(), color = Color.Black,
          fontSize = 20.sp,
          fontStyle = FontStyle.Normal,
          fontFamily = FontFamily.Monospace,
          textAlign = TextAlign.End
        )

      }
    }
  }
}