package com.oscar.f1app.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.oscar.f1app.R
import com.oscar.f1app.home.data.network.response.DriverResponse
import com.oscar.f1app.ui.theme.NunitoFamily




@Composable
fun DriverCard(modifier: Modifier, driver: DriverResponse){

    val colorLong = ("FF${driver.team_colour}").toLong(16)


    Row (modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(color = Color(0xFF222831))
        .padding(10.dp)
        .fillMaxWidth()
        .height(200.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(Modifier.padding(3.dp)){

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Column {
                        Text(text = driver.first_name, style = TextStyle( fontSize = 20.sp,
                            fontFamily = NunitoFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White))
                        Text(text = driver.last_name,
                            style = TextStyle(fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold))

                    }
                    Column {
                        Image(painter = painterResource(id = driver.photo),
                            contentDescription = "Adawdaw", modifier = Modifier.size(100.dp));
                           }


                }


                HorizontalDivider(thickness = 2.dp,
                    color = Color(colorLong),
                    modifier = Modifier.padding(top = 15.dp))

                Row {
                    BoxStats(driver.team_name, colorLong)
                    BoxStats(driver.driver_number.toString(), colorLong)
                    BoxStats(driver.name_acronym, colorLong)
                }


            }







    }

}

@Composable
fun BoxStats(info: String, teamColor: Long){
    Box(Modifier.padding(top = 15.dp, end = 8.dp).clip(RoundedCornerShape(5.dp)).background(Color(teamColor))){
        Text("${info}",
            modifier = Modifier.padding(5.dp),
            style = TextStyle(fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Normal))

    }
}