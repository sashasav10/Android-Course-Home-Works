package com.savelievoleksandr.p11.model

import com.google.gson.annotations.SerializedName

data class WeatherHourly(
    @SerializedName("city_name")
    val city_name: String,
    @SerializedName("country_code")
    val country_code: String,
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("state_code")
    val state_code: String,
    @SerializedName("timezone")
    val timezone: String
)

data class Data(
    @SerializedName("app_temp")
    val app_temp: Double,
    @SerializedName("clouds")
    val clouds: Double,
    @SerializedName("clouds_hi")
    val clouds_hi: Double,
    @SerializedName("clouds_low")
    val clouds_low: Double,
    @SerializedName("clouds_mid")
    val clouds_mid: Double,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("dhi")
    val dhi: Double,
    @SerializedName("dni")
    val dni: Double,
    @SerializedName("ghi")
    val ghi: Double,
    @SerializedName("ozone")
    val ozone: Double,
    @SerializedName("pod")
    val pod: String,
    @SerializedName("pop")
    val pop: Double,
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
    @SerializedName("snow_depth")
    val snow_depth: Double,
    @SerializedName("solar_rad")
    val solar_rad: Double,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("timestamp_local")
    val timestamp_local: String,
    @SerializedName("timestamp_utc")
    val timestamp_utc: String,
    @SerializedName("ts")
    val ts: Double,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("vis")
    val vis: Double,
    @SerializedName("weather")
    val weather: Weather2,
    @SerializedName("wind_cdir")
    val wind_cdir: String,
    @SerializedName("wind_cdir_full")
    val wind_cdir_full: String,
    @SerializedName("wind_dir")
    val wind_dir: Double,
    @SerializedName("wind_gust_spd")
    val wind_gust_spd: Double,
    @SerializedName("wind_spd")
    val wind_spd: Double
)

data class Weather2(
    val code: Double,
    val description: String,
    val icon: String
)