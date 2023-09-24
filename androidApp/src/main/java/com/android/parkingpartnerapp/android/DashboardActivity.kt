package com.android.parkingpartnerapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(8.dp)
                        ) {
                            Header()
                            VehicleLogView()
                            GridListView(createCardList())
                            BottomBar()
                    }
                }
            }
        }
    }
}


data class CardItem(val text: String, val image: String, val color: Color)

@Composable
fun GridListView(cardItem: List<CardItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ){
        items (cardItem){ item ->

            Column(modifier = Modifier
                .padding(4.dp)
                .background(item.color)) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(R.string.description)
                )

                Text(text = item.text,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = Color.Blue,
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun Header(){
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "03 September 2023", modifier = Modifier.fillMaxWidth())
        Text(text = "RUKMANI VIHAR PARKING",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun VehicleLogView(){
    Row(modifier = Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(1f)) {
                Text(text = "16",fontWeight = FontWeight.Bold,)
                Text(text = "Parked",
                    fontWeight = FontWeight.Bold,

                )
            }
        Column(modifier = Modifier
            .padding(8.dp)
            .weight(1f)) {
                Text(text = "16",fontWeight = FontWeight.Bold, )
                Text(text = "Out",
                    fontWeight = FontWeight.Bold,

                )
            }
        Column(modifier = Modifier
            .padding(8.dp)
            .weight(1f)) {
                Text(text = "Rs.1400",fontWeight = FontWeight.Bold, )
                Text(text = "Received",
                    fontWeight = FontWeight.Bold,
                )
            }
    }
}

@Composable
fun BottomBar() {
    NavigationBar() {
        NavigationBarItem(
            selected = true, onClick = { /*TODO*/ },
            icon = {Image(imageVector = Icons.Filled.Home , contentDescription = "Home")}
        )
        NavigationBarItem(
            selected = true, onClick = { /*TODO*/ },
            icon = {Image(imageVector = Icons.Filled.Person , contentDescription = "Profile")}
        )
    }
}

fun createCardList() : List<CardItem>{
    return listOf(
        CardItem("First", "https://pluralsight.imgix.net/course-images/audience/generic.jpg", Color.Gray),
        CardItem("First", "https://pluralsight.imgix.net/course-images/audience/generic.jpg", Color.Blue),
        CardItem("First", "https://pluralsight.imgix.net/course-images/audience/generic.jpg",Color.Green),
        CardItem("First", "https://pluralsight.imgix.net/course-images/audience/generic.jpg", Color.Magenta),
    )
}

@Preview
@Composable
fun GridListPreview() {

    MaterialTheme {
        GridListView(createCardList())
    }

}

@Preview
@Composable
fun HeaderPreview() {

    MaterialTheme {
        Header()
    }
}

@Preview
@Composable
fun VehicleLogPreview() {

    MaterialTheme {
        VehicleLogView()
    }

}
@Preview
@Composable
fun BottomBarPreview() {

    MaterialTheme {
        BottomBar()
    }

}
