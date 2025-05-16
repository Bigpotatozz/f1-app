package com.oscar.f1app.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscar.f1app.home.data.network.response.DriverResponse
import com.oscar.f1app.ui.theme.NunitoFamily


@Composable
fun HomeScreen(modifier: Modifier, HomeViewModel: HomeViewModel){

    val drivers: List<DriverResponse>? by HomeViewModel.drivers.observeAsState(initial = emptyList());

    Column(modifier.fillMaxSize().padding(15.dp)){
        Text("Drivers", style = TextStyle( fontFamily = NunitoFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp) )
        LazyColumn (modifier = Modifier.fillMaxSize()){

            items(drivers!!){
                DriverCard(modifier = Modifier, it);
                Spacer(modifier = Modifier.height(10.dp))
            }



        }
    }




}