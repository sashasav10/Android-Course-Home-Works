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


class WeatherAdapter(private val hours: WeatherHourly) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_hourly, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hour = hours.data[position]
        holder.hourlyTempTextView.text = hour.temp.toString() + "℃"
        holder.hourlyTimeTextView.text = hour.timestamp_local.substring(11, 16)

//КАК УСТАНОВИТЬ ИКОНКИ?
//        holder.icon.setImageResource(temp.toInt())
//        val temp = "R.drawable." + hour.weather.icon
//        val temp2: Int = temp.toInt()
//        holder.icon.setImageResource(temp2)
    }

    override fun getItemCount() = hours.data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.icon
        val hourlyTempTextView: TextView = itemView.hourlyTempTextView
        val hourlyTimeTextView: TextView = itemView.hourlyTimeTextView

    }
}
