package com.fullsteakdeveloper.weather.data.reponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER = 0

@Entity(tableName = "current_weather_response")
data class CurrentWeatherResponse(

	@Embedded(prefix = "request_")
	@field:SerializedName("request")
	val requestWeatherEntity: RequestWeatherEntity? = null,

	@Embedded(prefix = "current_")
	@field:SerializedName("current")
	val currentWeatherEntity: CurrentWeatherEntity? = null,

	@Embedded(prefix = "location_")
	@field:SerializedName("location")
	val location: Location? = null
)

@Entity(tableName = "request_weather_entity")
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

@Entity(tableName = "location")
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

@Entity(tableName = "current_weather_entity")
data class CurrentWeatherEntity(

	@Embedded(prefix = "weather_description_")
	@field:SerializedName("weather_descriptions")
	val weatherDescriptions: List<String?>? = null,

	@field:SerializedName("observation_time")
	val observationTime: String? = null,

	@field:SerializedName("wind_degree")
	val windDegree: Int? = null,

	@field:SerializedName("visibility")
	val visibility: Int? = null,

	@Embedded(prefix = "weather_icons_")
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
	val precip: Double? = null,

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
) {
	@PrimaryKey(autoGenerate = false)
	var id: Int = CURRENT_WEATHER
}

//Error
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

