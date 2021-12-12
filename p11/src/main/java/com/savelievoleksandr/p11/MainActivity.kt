package com.savelievoleksandr.p11

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.savelievoleksandr.p11.API.HourlyWeatherApiService
import com.savelievoleksandr.p11.API.WeatherApiService
import com.savelievoleksandr.p11.model.WeatherDay
import com.savelievoleksandr.p11.model.WeatherHourly
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var cityTextView: TextView = findViewById(R.id.cityTextView)
        var nowImageView: ImageView = findViewById(R.id.nowImageView)
        var DateTextView: TextView = findViewById(R.id.DateTextView)
        var nowTempTextView: TextView = findViewById(R.id.nowTempTextView)
        var nowWindTextView: TextView = findViewById(R.id.nowWindTextView)
        var nowRHTextView: TextView = findViewById(R.id.nowRHTextView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://weatherbit-v1-mashape.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherApiService = retrofit.create(WeatherApiService::class.java)
        weatherApiService.getToday(32.0617f, 49.4420f).enqueue(object : Callback<WeatherDay> {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call<WeatherDay>, response: Response<WeatherDay>) {
                cityTextView.text = response.body()?.data?.get(0)?.city_name
                nowTempTextView.text = response.body()?.data?.get(0)?.temp.toString() + "℃"
                DateTextView.text = response.body()?.data?.get(0)?.ob_time?.substring(0, 11)
                nowWindTextView.text =
                    String.format("%.2f", response.body()?.data?.get(0)?.wind_spd)
                nowRHTextView.text = String.format("%.2f", response.body()?.data?.get(0)?.rh) + "%"
                nowImageView.setImageDrawable(
                    getDrawable(
                        resources.getIdentifier(
                            "@drawable/" + response.body()?.data?.get(0)?.weather?.icon,
                            null, packageName,
                        ),
                    ),
                )
            }

            override fun onFailure(call: Call<WeatherDay>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })


        val hourlyWeatherApiService = retrofit.create(HourlyWeatherApiService::class.java)
        hourlyWeatherApiService.getToday(49.4420f, 32.0617f, 24)
            .enqueue(object : Callback<WeatherHourly> {
                override fun onResponse(
                    call: Call<WeatherHourly>,
                    response: Response<WeatherHourly>
                ) {
                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = WeatherAdapter(response.body()!!)
                }

                override fun onFailure(call: Call<WeatherHourly>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}