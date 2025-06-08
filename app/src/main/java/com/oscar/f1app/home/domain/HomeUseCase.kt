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
                "Max VERSTAPPEN" -> driver.photo = R.drawable.max
                "Logan SARGEANT" -> driver.photo = R.drawable.sargeant
                "Lando NORRIS" -> driver.photo = R.drawable.norris
                "Pierre GASLY" -> driver.photo = R.drawable.gasly
                "Sergio PEREZ" -> driver.photo = R.drawable.perez
                "Fernando ALONSO" -> driver.photo = R.drawable.alonso
                "Kevin MAGNUSSEN" -> driver.photo = R.drawable.magnussen
                "Lance STROLL" -> driver.photo = R.drawable.stroll
                "Yuki TSUNODA" -> driver.photo = R.drawable.tsunoda
                "Charles LECLERC" -> driver.photo = R.drawable.lecrerc
                "Alexander ALBON" -> driver.photo = R.drawable.albon
                "ZHOU Guanyu" -> driver.photo = R.drawable.zhou
                "Nico HULKENBERG" -> driver.photo = R.drawable.hulkenberg
                "Esteban OCON" -> driver.photo = R.drawable.ocon
                "Liam LAWSON" -> driver.photo = R.drawable.lawson
                "Lewis HAMILTON" -> driver.photo = R.drawable.hamilton
                "Carlos SAINZ" -> driver.photo = R.drawable.sainz
                "George RUSSELL" -> driver.photo = R.drawable.rusell
                "Valtteri BOTTAS" -> driver.photo = R.drawable.bottas
                "Oscar PIASTRI" -> driver.photo = R.drawable.piastri

                else -> driver.photo = R.drawable.ic_launcher_background
            }
        }

        return drivers;

    }

}