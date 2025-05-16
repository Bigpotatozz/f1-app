package com.oscar.f1app.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.f1app.home.data.network.response.DriverResponse


@Composable
fun HomeScreen(modifier: Modifier, HomeViewModel: HomeViewModel){

    val drivers: List<DriverResponse>? by HomeViewModel.drivers.observeAsState(initial = emptyList());

    LazyColumn (modifier.fillMaxWidth().padding(15.dp)){

        items(drivers!!){
            DriverCard(modifier = Modifier, it);
            Spacer(modifier = Modifier.height(10.dp))
        }



    }


}