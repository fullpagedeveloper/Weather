package com.fullsteakdeveloper.weather.data.reponse

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fullsteakdeveloper.weather.data.ApiXuWeatherApiService
import com.fullsteakdeveloper.weather.internal.NoConnectActivityException

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApiXuWeatherApiService
    ) : WeatherNetworkDataSource {
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchCurrentWeather = apixuWeatherApiService
                .getCurrentWeather(location)
                .await()
            _downloadedCurrentWeather.value = fetchCurrentWeather
        } catch (e: NoConnectActivityException) {
            Log.e("Connection", "No Internet Connection", e)
        }
    }
}