package com.savelievoleksandr.p11.API

import com.savelievoleksandr.p11.model.WeatherDay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApiService {
   @Headers("X-RapidAPI-Key:b1a7f67b18msh424b6cb334a03c7p1396e6jsna22b094ae39b")
    @GET("current")
   fun getToday(
       @Query("lon") lon:Float,
       @Query("lat") lat:Float
   ): Call<WeatherDay>
}