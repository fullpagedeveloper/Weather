package com.fullsteakdeveloper.weather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fullsteakdeveloper.weather.data.reponse.CurrentWeatherResponse

@Database(
    entities = [CurrentWeatherResponse::class],
    version = 1
)

/**
 * @see
 */
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile
        private var instance: WeatherDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            "weather.db"
        ).build()
    }
}