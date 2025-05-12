package com.oscar.f1app.home.data.network

import com.oscar.f1app.core.RetrofitHelper
import com.oscar.f1app.home.data.network.response.DriverResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeService {

    val retrofit = RetrofitHelper.getRetrofit();

    suspend fun getDrivers(): List<DriverResponse>? {
        return withContext(Dispatchers.IO){
           val response =  retrofit.create(HomeClient::class.java).getDrivers();
            response.body();
        }
    }


}