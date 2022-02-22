package com.fullsteakdeveloper.weather.ui.weather.current

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.fullsteakdeveloper.weather.R
import com.fullsteakdeveloper.weather.data.ApiXuWeatherApiService
import com.fullsteakdeveloper.weather.data.reponse.ConnectivityInterceptorImpl
import com.fullsteakdeveloper.weather.data.reponse.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)

        val apiService = ApiXuWeatherApiService(ConnectivityInterceptorImpl(this.requireContext()))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadCurrentWeather.observe(
            viewLifecycleOwner,
            Observer { textView_CurrentWeather.text = it.toString() })

        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiService.getCurrentWeather("Jakarta, Indonesia").await()

            Log.d("TAG", "RESPONSE $currentWeatherResponse")
            weatherNetworkDataSource.fetchCurrentWeather("Jakarta, Indonesia")

//            textView_CurrentWeather.text = currentWeatherResponse.location.toString()
            Log.d("TAG", "${currentWeatherResponse.RequestWeatherEntity}")

        }
    }

}