package com.oscar.f1app.home.domain

import com.oscar.f1app.R
import com.oscar.f1app.home.data.HomeRepository
import com.oscar.f1app.home.data.network.response.DriverResponse
import javax.inject.Inject


class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(): List<DriverResponse>?{
        var drivers =  homeRepository.getDrivers();

        for (driver in drivers!!){
            when(driver.full_name){
                "Max VERSTAPPEN" -> driver.photo = R.drawable.verstappen
                else -> driver.photo = R.drawable.ic_launcher_background
            }
        }

        return drivers;

    }

}