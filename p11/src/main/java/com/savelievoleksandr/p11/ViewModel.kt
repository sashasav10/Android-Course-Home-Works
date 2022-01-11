package com.savelievoleksandr.p11

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.savelievoleksandr.p11.API.HourlyWeatherApiService
import com.savelievoleksandr.p11.model.WeatherHourly
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModel(application: Application) : AndroidViewModel(application) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val hourlyWeatherApiService = retrofit.create(HourlyWeatherApiService::class.java)
    private val _weatherLiveData = MutableLiveData<WeatherHourly>()
    val weatherLiveData: LiveData<WeatherHourly> = _weatherLiveData
    fun getWeather() {
        hourlyWeatherApiService.getToday(49.4420f, 32.0617f, 24).enqueue(object :
            Callback<WeatherHourly> {
            override fun onResponse(call: Call<WeatherHourly>, response: Response<WeatherHourly>) {
                _weatherLiveData.value = response.body()
            }

            override fun onFailure(call: Call<WeatherHourly>, t: Throwable) {
            }
        })
    }
}