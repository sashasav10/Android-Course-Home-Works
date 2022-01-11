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
    }
}