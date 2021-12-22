package com.savelievoleksandr.p11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.savelievoleksandr.p11.model.WeatherHourly
import kotlinx.android.synthetic.main.activity_hourly.view.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.bumptech.glide.Glide
import com.savelievoleksandr.p11.model.Data


class WeatherAdapter(private val hours: WeatherHourly, val mainActivity: MainActivity) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_hourly, parent, false)
        return ViewHolder(itemView, mainActivity)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        hours.data?.let { holder.bind(it.get(position)) }
    }

    override fun getItemCount() = hours.data.size

    inner class ViewHolder(itemView: View, mainActivity: MainActivity) :
        RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.icon
        val hourlyTempTextView: TextView = itemView.hourlyTempTextView
        val hourlyTimeTextView: TextView = itemView.hourlyTimeTextView
        fun bind(data: Data) {
            hourlyTempTextView.text = data.temp.toString() + "℃"
            hourlyTimeTextView.text = data.timestamp_local.substring(11, 16)
            when(data.weather.icon){
                "a01d"->icon.setImageResource(R.drawable.a01d)
                "a01n"->icon.setImageResource(R.drawable.a01n)
                "a02d"->icon.setImageResource(R.drawable.a02d)
                "a02n"->icon.setImageResource(R.drawable.a02n)
                "a03d"->icon.setImageResource(R.drawable.a03d)
                "a03n"->icon.setImageResource(R.drawable.a03n)
                "a04d"->icon.setImageResource(R.drawable.a04d)
                "a04n"->icon.setImageResource(R.drawable.a04n)
                "a05d"->icon.setImageResource(R.drawable.a05d)
                "a05n"->icon.setImageResource(R.drawable.a05n)
                "a06d"->icon.setImageResource(R.drawable.a06d)
                "a06n"->icon.setImageResource(R.drawable.a06n)
                "c01d"->icon.setImageResource(R.drawable.c01d)
                "c01n"->icon.setImageResource(R.drawable.c01n)
                "c02d"->icon.setImageResource(R.drawable.c02d)
                "c02n"->icon.setImageResource(R.drawable.c02n)
                "c03d"->icon.setImageResource(R.drawable.c03d)
                "c03n"->icon.setImageResource(R.drawable.c03n)
                "c04d"->icon.setImageResource(R.drawable.c04d)
                "c04n"->icon.setImageResource(R.drawable.c04n)
                "d01d"->icon.setImageResource(R.drawable.d01d)
                "d01n"->icon.setImageResource(R.drawable.d01n)
                "d02d"->icon.setImageResource(R.drawable.d02d)
                "d02n"->icon.setImageResource(R.drawable.d02n)
                "d03d"->icon.setImageResource(R.drawable.d03d)
                "d03n"->icon.setImageResource(R.drawable.d03n)
                "f01d"->icon.setImageResource(R.drawable.f01d)
                "f01n"->icon.setImageResource(R.drawable.f01n)
                "r01d"->icon.setImageResource(R.drawable.r01d)
                "r01n"->icon.setImageResource(R.drawable.r01n)
                "r02d"->icon.setImageResource(R.drawable.r02d)
                "r02n"->icon.setImageResource(R.drawable.r02n)
                "r03d"->icon.setImageResource(R.drawable.r03d)
                "r03n"->icon.setImageResource(R.drawable.r03n)
                "r04d"->icon.setImageResource(R.drawable.r04d)
                "r04n"->icon.setImageResource(R.drawable.r04n)
                "r05d"->icon.setImageResource(R.drawable.r05d)
                "r05n"->icon.setImageResource(R.drawable.r05n)
                "r06d"->icon.setImageResource(R.drawable.r06d)
                "r06n"->icon.setImageResource(R.drawable.r06n)
                "s01d"->icon.setImageResource(R.drawable.s01d)
                "s01n"->icon.setImageResource(R.drawable.s01n)
                "s02d"->icon.setImageResource(R.drawable.s02d)
                "s02n"->icon.setImageResource(R.drawable.s02n)
                "s03d"->icon.setImageResource(R.drawable.s03d)
                "s03n"->icon.setImageResource(R.drawable.s03n)
                "s04d"->icon.setImageResource(R.drawable.s04d)
                "s04n"->icon.setImageResource(R.drawable.s04n)
                "s05d"->icon.setImageResource(R.drawable.s05d)
                "s05n"->icon.setImageResource(R.drawable.s05n)
                "s06d"->icon.setImageResource(R.drawable.s06d)
                "s06n"->icon.setImageResource(R.drawable.s06n)
                "t01d"->icon.setImageResource(R.drawable.t01d)
                "t01n"->icon.setImageResource(R.drawable.t01n)
                "t02d"->icon.setImageResource(R.drawable.t02d)
                "t02n"->icon.setImageResource(R.drawable.t02n)
                "t03d"->icon.setImageResource(R.drawable.t03d)
                "t03n"->icon.setImageResource(R.drawable.t03n)
                "t04d"->icon.setImageResource(R.drawable.t04d)
                "t04n"->icon.setImageResource(R.drawable.t04n)
                "t05d"->icon.setImageResource(R.drawable.t05d)
                "t05n"->icon.setImageResource(R.drawable.t05n)
                "u00d"->icon.setImageResource(R.drawable.u00d)
                "u00n"->icon.setImageResource(R.drawable.u00n)
            }
        }
    }
}
