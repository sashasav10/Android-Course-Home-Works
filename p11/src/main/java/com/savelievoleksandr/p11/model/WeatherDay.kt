package com.savelievoleksandr.p11.model

import com.google.gson.annotations.SerializedName
data class WeatherDay(
    @SerializedName("count")
    val count: Double,
    @SerializedName("data")
    val data: List<WeatherDayX>
)

data class WeatherDayX(
    @SerializedName("app_temp")
    val app_temp: Double,
    @SerializedName("aqi")
    val aqi: Double,
    @SerializedName("city_name")
    val city_name: String,
    @SerializedName("clouds")
    val clouds: Double,
    @SerializedName("country_code")
    val country_code: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("dhi")
    val dhi: Double,
    @SerializedName("dni")
    val dni: Double,
    @SerializedName("elev_angle")
    val elev_angle: Double,
    @SerializedName("ghi")
    val ghi: Double,
    @SerializedName("h_angle")
    val h_angle: Double,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("ob_time")
    val ob_time: String,
    @SerializedName("pod")
    val pod: String,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("rh")
    val rh: Double,
    @SerializedName("slp")
    val slp: Double,
    @SerializedName("snow")
    val snow: Double,
    @SerializedName("solar_rad")
    val solar_rad: Double,
    @SerializedName("state_code")
    val state_code: String,
    @SerializedName("station")
    val station: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("ts")
    val ts: Double,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("vis")
    val vis: Double,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_cdir")
    val wind_cdir: String,
    @SerializedName("wind_cdir_full")
    val wind_cdir_full: String,
    @SerializedName("wind_dir")
    val wind_dir: Double,
    @SerializedName("wind_spd")
    val wind_spd: Double
)

data class Weather(
    @SerializedName("code")
    val code: Double,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)