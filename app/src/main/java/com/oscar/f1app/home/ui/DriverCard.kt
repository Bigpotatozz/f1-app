package com.oscar.f1app.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.oscar.f1app.home.data.network.response.DriverResponse

@Composable
fun DriverCard(driver: DriverResponse){
    Text("${driver.first_name} ${driver.last_name}");
}