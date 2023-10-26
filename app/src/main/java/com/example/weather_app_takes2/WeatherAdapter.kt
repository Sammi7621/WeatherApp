package com.example.weather_app_takes2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class WeatherAdapter(private val weatherList: MutableList<WeatherModal>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeText: TextView = itemView.findViewById(R.id.TimeText)
        val tempText: TextView = itemView.findViewById(R.id.TempText)
        val weatherIcon: ImageView = itemView.findViewById(R.id.WeatherIcon)
        val cityText: TextView = itemView.findViewById(R.id.CityText)
    }

    fun updateList(newList: List<WeatherModal>) {
        weatherList.clear()
        weatherList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = weatherList[position]
        currentItem.temperature = currentItem.temperature + "°C"
        holder.cityText.text = currentItem.city
        holder.timeText.text = currentItem.time
        holder.tempText.text = currentItem.temperature
        // Ensure the URL starts with a protocol (e.g., "https:")
        val imageUrl = if (currentItem.icon.startsWith("//")) {
            "https:${currentItem.icon}"
        } else {
            currentItem.icon
        }

        // Using Glide to load image from URL into ImageView
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.weatherIcon)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}
