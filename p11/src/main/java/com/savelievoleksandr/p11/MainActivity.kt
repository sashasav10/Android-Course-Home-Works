package com.savelievoleksandr.p11

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var weatherViewModel: ViewModel
    lateinit var recyclerView: RecyclerView

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var cityTextView: TextView = findViewById(R.id.cityTextView)
        var nowImageView: ImageView = findViewById(R.id.nowImageView)
        var DateTextView: TextView = findViewById(R.id.DateTextView)
        var nowTempTextView: TextView = findViewById(R.id.nowTempTextView)
        var nowWindTextView: TextView = findViewById(R.id.nowWindTextView)
        var nowRHTextView: TextView = findViewById(R.id.nowRHTextView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        weatherViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        weatherViewModel.weatherLiveData.observe(this)
        {
            cityTextView.text = it.city_name
            DateTextView.text = it.data?.get(0)?.datetime.substring(0, 11)
            nowTempTextView.text = it.data?.get(0)?.temp.toString() + "℃"
            nowWindTextView.text = String.format("%.2f", it.data?.get(0)?.wind_spd)
            nowRHTextView.text = String.format("%.2f", it.data?.get(0)?.rh) + "%"
            nowImageView.setImageDrawable(
                getDrawable(
                    resources.getIdentifier(
                        "@drawable/" + it.data?.get(0)?.weather?.icon,
                        null, packageName,
                    ),
                ),
            )
            recyclerView.adapter = WeatherAdapter(it, this)

        }
        weatherViewModel.getWeather()

//        weatherApiService.getToday(32.0617f, 49.4420f).enqueue(object : Callback<WeatherDay> {
//            @SuppressLint("UseCompatLoadingForDrawables")
//            override fun onResponse(call: Call<WeatherDay>, response: Response<WeatherDay>) {
//                cityTextView.text = response.body()?.data?.get(0)?.city_name
//                nowTempTextView.text = response.body()?.data?.get(0)?.temp.toString() + "℃"
//                DateTextView.text = response.body()?.data?.get(0)?.ob_time?.substring(0, 11)
//                nowWindTextView.text =
//                    String.format("%.2f", response.body()?.data?.get(0)?.wind_spd)
//                nowRHTextView.text = String.format("%.2f", response.body()?.data?.get(0)?.rh) + "%"
//                nowImageView.setImageDrawable(
//                    getDrawable(
//                        resources.getIdentifier(
//                            "@drawable/" + response.body()?.data?.get(0)?.weather?.icon,
//                            null, packageName,
//                        ),
//                    ),
//                )
//            }
//
////            override fun onFailure(call: Call<WeatherDay>, t: Throwable) {
////                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
////            }
//        })


//        val hourlyWeatherApiService = retrofit.create(HourlyWeatherApiService::class.java)
//        hourlyWeatherApiService.getToday(49.4420f, 32.0617f, 24)
//            .enqueue(object : Callback<WeatherHourly> {
//                override fun onResponse(
//                    call: Call<WeatherHourly>,
//                    response: Response<WeatherHourly>
//                ) {
//                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                    recyclerView.adapter = WeatherAdapter(response.body()!!)
//                }
//
//                override fun onFailure(call: Call<WeatherHourly>, t: Throwable) {
//                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
//                }
//            })
    }
}