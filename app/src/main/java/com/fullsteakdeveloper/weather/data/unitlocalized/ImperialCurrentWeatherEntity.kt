package com.fullsteakdeveloper.weather.data.unitlocalized

import androidx.room.ColumnInfo

data class ImperialCurrentWeatherEntity(
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "weather_icons")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "wind_speed")
    override val windSpeed: Double,
    @ColumnInfo(name = "wind_dir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double,
    @ColumnInfo(name = "request")
    override val requestWeatherEntity: String,
    @ColumnInfo(name = "current")
    override val currentWeatherEntity: String,
    @ColumnInfo(name = "location")
    override val location: String
) : UnitSpecificCurrentWeather