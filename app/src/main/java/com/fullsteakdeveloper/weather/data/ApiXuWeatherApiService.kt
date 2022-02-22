package com.fullsteakdeveloper.weather.data

import android.util.Log
import com.fullsteakdeveloper.weather.data.reponse.ConnectivityInterceptor
import com.fullsteakdeveloper.weather.data.reponse.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "http://api.weatherstack.com/"
const val API_KEY = "d9eaeda4ed5578f5dc4833c1f7661085"
//http://api.weatherstack.com/current?access_key=d9eaeda4ed5578f5dc4833c1f7661085&query=New%20York

interface ApiXuWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String
    ): Deferred<CurrentWeatherResponse>


    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): ApiXuWeatherApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                Log.d("TAG  =>", "$request === ${chain.request().headers()}")
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiXuWeatherApiService::class.java)
        }
    }
}