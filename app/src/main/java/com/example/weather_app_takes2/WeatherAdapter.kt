package com.example.weather_app_takes2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class WeatherAdapter(private val weatherList: List<Group>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityText: TextView = itemView.findViewById(R.id.CityText)
        val tempText: TextView = itemView.findViewById(R.id.TempText)
        val timeText: TextView = itemView.findViewById(R.id.TimeText)
        val weatherIcon: ImageView = itemView.findViewById(R.id.WeatherIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = weatherList[position]

        holder.cityText.text = currentItem.city
        holder.tempText.text = currentItem.temp
        holder.timeText.text = currentItem.time

        // Using Glide to load image from URL into ImageView
        Glide.with(holder.itemView.context)
            .load(currentItem.img)
            .into(holder.weatherIcon)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}
