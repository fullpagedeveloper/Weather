package com.fullsteakdeveloper.weather.data.unitlocalized

interface UnitSpecificCurrentWeather {
    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
    val requestWeatherEntity: String
    val currentWeatherEntity: String
    val location: String
}