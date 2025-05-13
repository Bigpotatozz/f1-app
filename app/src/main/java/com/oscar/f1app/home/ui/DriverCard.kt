package com.oscar.f1app.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.oscar.f1app.home.data.network.response.DriverResponse


@Composable
fun DriverCard(modifier: Modifier, driver: DriverResponse){


    Row (modifier = Modifier
        .background(Color.Gray)
        .padding(10.dp)
        .fillMaxWidth()
        .height(50.dp),
        verticalAlignment = Alignment.CenterVertically){
        Column {
            AsyncImage(
                model = driver.headshot_url,
                contentDescription = "foto del piloto",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(50.dp)
            )
        }
        Column {
            Text(text = driver.first_name, style = TextStyle( fontSize = 20.sp))
            Text(text = driver.last_name, style = TextStyle( fontSize = 15.sp))
        }
    }
}