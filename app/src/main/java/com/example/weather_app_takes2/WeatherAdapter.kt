package com.example.weather_app_takes2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Context
import android.content.Intent


class WeatherAdapter(private val weatherList: MutableList<WeatherModal>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private lateinit var context: Context
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeText: TextView = itemView.findViewById(R.id.TimeText)
        val tempText: TextView = itemView.findViewById(R.id.TempText)
        val weatherIcon: ImageView = itemView.findViewById(R.id.WeatherIcon)
        val cityText: TextView = itemView.findViewById(R.id.CityText)
        val bigButton: Button = itemView.findViewById(R.id.BigButton)
    }

    fun updateList(newList: List<WeatherModal>) {
        weatherList.clear()
        weatherList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
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

        holder.bigButton.setOnClickListener {
            // Create an Intent to start SecondActivity
            val intent = Intent(context, SecondActivity::class.java)
            // Add the city name as an extra to the Intent
            intent.putExtra("cityName", currentItem.city)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}
