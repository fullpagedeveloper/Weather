package com.fullsteakdeveloper.weather.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fullsteakdeveloper.weather.data.reponse.CURRENT_WEATHER
import com.fullsteakdeveloper.weather.data.reponse.CurrentWeatherEntity
import com.fullsteakdeveloper.weather.data.unitlocalized.ImperialCurrentWeatherEntity

@Dao
interface CurrentWeatherDao {
    /**
     * <p>
     * update dan insert => upsert
     * @param weatherEntity
     * @see CurrentWeatherEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntity: CurrentWeatherEntity)

    /**
     * @return {@link LiveData<ImperialCurrentWeatherEntity>}
     */
    @Query("select * from current_weather_entity where id = $CURRENT_WEATHER")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntity>
}