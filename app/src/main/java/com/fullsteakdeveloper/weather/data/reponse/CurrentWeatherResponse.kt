package com.fullsteakdeveloper.weather.data.reponse

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

	@field:SerializedName("request")
	val RequestWeatherEntity: RequestWeatherEntity? = null,

	@field:SerializedName("current")
	val CurrentWeatherEntity: CurrentWeatherEntity? = null,

	@field:SerializedName("location")
	val location: Location? = null
)

data class RequestWeatherEntity(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("query")
	val query: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Location(

	@field:SerializedName("localtime")
	val localtime: String? = null,

	@field:SerializedName("utc_offset")
	val utcOffset: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("localtime_epoch")
	val localtimeEpoch: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("timezone_id")
	val timezoneId: String? = null,

	@field:SerializedName("lon")
	val lon: String? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null
)

data class CurrentWeatherEntity(

	@field:SerializedName("weather_descriptions")
	val weatherDescriptions: List<String?>? = null,

	@field:SerializedName("observation_time")
	val observationTime: String? = null,

	@field:SerializedName("wind_degree")
	val windDegree: Int? = null,

	@field:SerializedName("visibility")
	val visibility: Int? = null,

	@field:SerializedName("weather_icons")
	val weatherIcons: List<String?>? = null,

	@field:SerializedName("feelslike")
	val feelslike: Int? = null,

	@field:SerializedName("is_day")
	val isDay: String? = null,

	@field:SerializedName("wind_dir")
	val windDir: String? = null,

	@field:SerializedName("pressure")
	val pressure: Int? = null,

	@field:SerializedName("cloudcover")
	val cloudcover: Int? = null,

	@field:SerializedName("precip")
	val precip: Int? = null,

	@field:SerializedName("uv_index")
	val uvIndex: Int? = null,

	@field:SerializedName("temperature")
	val temperature: Int? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("wind_speed")
	val windSpeed: Int? = null,

	@field:SerializedName("weather_code")
	val weatherCode: Int? = null
)

data class Response(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("error")
	val error: Error? = null
)

data class Error(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("info")
	val info: String? = null
)

