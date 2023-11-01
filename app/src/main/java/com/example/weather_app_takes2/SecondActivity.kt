package com.example.weather_app_takes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask
import com.google.gson.Gson
import java.text.SimpleDateFormat
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private val API: String = "d1a60da1c7934bf6b6764013232410"

    private val TAG = "SecondActivity"
    private val timer = Timer()

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun loadImageIntoImageView(imageView: ImageView, imageUrl: String) {
        val fullImageUrl = if (imageUrl.startsWith("//")) {
            "https:$imageUrl"
        } else {
            imageUrl
        }

        Glide.with(this)
            .load(fullImageUrl)
            .into(imageView)
    }

    private fun displayData(hours: HourModal, cityName: String) {
        Log.d(TAG, "Displaying weather data")

        val hoursToDisplay: MutableList<Hour> = mutableListOf()

        val nowTimeString = hours.time.split(" ")[1]
        val dateFormat = SimpleDateFormat("HH:mm")

        try {
            val nowTime = dateFormat.parse(nowTimeString)
            val cutoffTime = dateFormat.parse("18:00")

            if (nowTime != null && cutoffTime != null) {
                if (nowTime >= cutoffTime) {
                    val lastSixHours = hours.hours.takeLast(6)
                    hoursToDisplay.addAll(lastSixHours)
                } else {
                    for (hour in hours.hours) {
                        val hourTime = hour.time.split(" ")[1]
                        val parsedHourTime = dateFormat.parse(hourTime)

                        if (parsedHourTime != null && parsedHourTime >= nowTime && hoursToDisplay.size < 6) {
                            hoursToDisplay.add(hour)
                        }
                    }
                }
            } else {
                val lastSixHours = hours.hours.takeLast(6)
                hoursToDisplay.addAll(lastSixHours)
            }
        } catch (e: Exception) {
            showError("no Data. Please try again.")
            e.printStackTrace()
        }

        val button = findViewById<Button>(R.id.FullTimeButton)
        // Use String.format to insert values into the placeholders
        val fullTimeFormat = getString(R.string.full_time_format)
        val buttonText = String.format(fullTimeFormat, cityName, hours.time)
        button.text = buttonText

        val temperatureTextView = findViewById<TextView>(R.id.tempText)
        val bigLogoImageView = findViewById<ImageView>(R.id.BigLogo)

        hours.temperature = "${hours.temperature}°C"
        temperatureTextView.text = hours.temperature
        loadImageIntoImageView(bigLogoImageView, hours.icon)

        for ((index, hour) in hoursToDisplay.withIndex()) {
            val timeTextViewId = resources.getIdentifier("time${index + 1}", "id", packageName)
            val tempTextViewId = resources.getIdentifier("temp${index + 1}", "id", packageName)
            val imgImageViewId = resources.getIdentifier("icontime${index + 1}", "id", packageName)

            val timeTextView = findViewById<TextView>(timeTextViewId)
            val tempTextView = findViewById<TextView>(tempTextViewId)
            val imgImageView = findViewById<ImageView>(imgImageViewId)

            timeTextView.text = hour.time.split(" ")[1]
            hour.temperature = "${hour.temperature}°C"
            tempTextView.text = hour.temperature
            loadImageIntoImageView(imgImageView, hour.icon)
        }

        val precipTextView = findViewById<TextView>(R.id.PrecipText)
        precipTextView.text = hours.precip_mm

        val humidTextView = findViewById<TextView>(R.id.HumidText)
        humidTextView.text = hours.humidity

        val uvTextView = findViewById<TextView>(R.id.UVText)
        uvTextView.text = hours.uv
    }




    private suspend fun getWeatherDataFromAPI(city: String): HourModal {
        Log.d(TAG, "Fetching weather data for city: $city")

        val updatedHourList = mutableListOf<Hour>()

        try {
            val response = RetrofitInstance.weatherApi.getCurrentWeatherForecast(API, city, "no")
            Log.d(TAG, "JSON Response: ${Gson().toJson(response)}") // Log the entire response


            val weatherData1 = response.current
            val weatherData2 = response.location
            val weatherData3 = response.forecast
            // Create an empty list to store updatedHourList
            weatherData2.localtime
            for (time in weatherData3.forecastday[0].hour) {
                // Create Hour objects and add them to updatedHourList
                updatedHourList.add(
                    Hour(
                        time.time,
                        time.temp_c.toInt().toString(),
                        time.condition.icon
                    )
                )
            }

            return HourModal(
                weatherData2.localtime,
                weatherData1.temp_c.toInt().toString(),
                weatherData1.condition.icon,
                weatherData1.wind_kph.toString(),
                weatherData1.uv.toInt().toString(),
                weatherData1.humidity.toInt().toString(),
                weatherData1.precip_mm.toInt().toString(),
                weatherData3.forecastday[0].day.maxtemp_c.toString(),
                weatherData3.forecastday[0].day.mintemp_c.toString(),
                weatherData3.forecastday[0].day.avgtemp_c.toString(),
                updatedHourList // Use the populated updatedHourList
            )
        } catch (e: Exception) {
            showError("Network error. Please try again.")
            Log.e(TAG, "Network Error: ${e.message ?: "Unknown error"}", e)
            e.printStackTrace()

            return HourModal(
                "", // Empty values for the other properties
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                mutableListOf() // An empty list for _hours
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        setContentView(R.layout.activity_second)

        var cityName = intent.getStringExtra("cityName")
        Log.d(TAG, cityName?:"ahhhh")

        if (cityName == null) {
            cityName = ""
        }


        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                Log.d(TAG, "Fetching data at fixed rate")

                lifecycleScope.launch {
                    displayData(getWeatherDataFromAPI(cityName),cityName)
                }
            }
        }, 0, 60000)

        val img =findViewById<ImageView>(R.id.BackImg)
        img.setOnClickListener {
            finish()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }


}
