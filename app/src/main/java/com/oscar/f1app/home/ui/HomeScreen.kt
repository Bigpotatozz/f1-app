package com.oscar.f1app.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.oscar.f1app.home.data.network.response.DriverResponse


@Composable
fun HomeScreen(modifier: Modifier, HomeViewModel: HomeViewModel){

    val drivers: List<DriverResponse>? by HomeViewModel.drivers.observeAsState(initial = emptyList());

    Column (modifier){
            for(driver in drivers!!) {
                DriverCard(driver);
            }
    }


}