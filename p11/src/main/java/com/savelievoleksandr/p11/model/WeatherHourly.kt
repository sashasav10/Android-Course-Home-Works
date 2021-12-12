package com.savelievoleksandr.p11.model

data class WeatherHourly(
    val city_name: String,
    val country_code: String,
    val data: List<Data>,
    val lat: Double,
    val lon: Double,
    val state_code: String,
    val timezone: String
)

data class Data(
    val app_temp: Double,
    val clouds: Double,
    val clouds_hi: Double,
    val clouds_low: Double,
    val clouds_mid: Double,
    val datetime: String,
    val dewpt: Double,
    val dhi: Double,
    val dni: Double,
    val ghi: Double,
    val ozone: Double,
    val pod: String,
    val pop: Double,
    val precip: Double,
    val pres: Double,
    val rh: Double,
    val slp: Double,
    val snow: Double,
    val snow_depth: Double,
    val solar_rad: Double,
    val temp: Double,
    val timestamp_local: String,
    val timestamp_utc: String,
    val ts: Double,
    val uv: Double,
    val vis: Double,
    val weather: Weather2,
    val wind_cdir: String,
    val wind_cdir_full: String,
    val wind_dir: Double,
    val wind_gust_spd: Double,
    val wind_spd: Double
)

data class Weather2(
    val code: Double,
    val description: String,
    val icon: String
)