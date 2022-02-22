package com.fullsteakdeveloper.weather.data.reponse

import androidx.lifecycle.LiveData

interface WeatherNetworkDataSource {
    val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
}