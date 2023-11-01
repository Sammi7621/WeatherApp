package com.example.weather_app_takes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import android.view.View
import kotlinx.coroutines.Dispatchers
import java.util.Timer
import java.util.TimerTask
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    private val API: String = "d1a60da1c7934bf6b6764013232410"
    private val timer = Timer()
    // Declare RecyclerView and data list variables
    private lateinit var groupRecyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter
    private lateinit var progressBar: ProgressBar
    private var counter = 0
    private var textInput = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        groupRecyclerView = findViewById(R.id.recyclerView)
        groupRecyclerView.layoutManager = LinearLayoutManager(this)
        groupRecyclerView.setHasFixedSize(true)
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                performSearch(textInput)
            }
        }, 0, 60000)
        val searchBar = findViewById<SearchView>(R.id.SearchBar)
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle when the search button is pressed (or Enter key)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle as the text changes
                textInput= newText?:""
                performSearch(textInput)
                return true
            }

        })
    }
    override fun onDestroy() {
        super.onDestroy()
        // Stop the auto-refresh when the activity is destroyed
        timer.cancel()
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private suspend fun getWeatherDataFromAPI(cities: List<String>): MutableList<WeatherModal> {
        val weatherList = mutableListOf<WeatherModal>()
        for (city in cities) {
            try {
                val response = RetrofitInstance.weatherApi.getCurrentWeather(API, city, "no")
                val weatherData1 = response.current
                val weatherData2 = response.location

                val weatherModal = WeatherModal(
                    city,
                    weatherData2.localtime,
                    weatherData1.temp_c.toInt().toString(),  // Convert temp_c to String
                    weatherData1.condition.icon,
                )
                weatherList.add(weatherModal)
            } catch (e: Exception) {
                // Handle network error
                showError("Network error. Please try again.")
                Log.e("Network Error", e.message ?: "Unknown error")
                e.printStackTrace()
            }
        }
        return weatherList
    }


    private suspend fun loadDefaultCities() {
        val defaultCities = mutableListOf(
        "Melbourne",
        "Brisbane",
        "Perth",
        "Tasmania",
        "Sydney",
        "Adelaide"
        )
        val citiesData = getWeatherDataFromAPI(defaultCities)
        // remove the progress bar
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.GONE
        // Update the RecyclerView
        weatherAdapter = WeatherAdapter(citiesData)
        groupRecyclerView.adapter = weatherAdapter
    }

    private suspend fun searchCities(query: String) {
        val matchedCities = CityList.cities.filter { it.startsWith(query, ignoreCase = true) }.take(10)
        val citiesData = getWeatherDataFromAPI(matchedCities)
        // remove the progress bar
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.GONE
        // Update the RecyclerView
        weatherAdapter = WeatherAdapter(citiesData)
        groupRecyclerView.adapter = weatherAdapter

    }

    private fun performSearch(query: String) {
        lifecycleScope.launch {
            // make progress bar visible
            progressBar = findViewById(R.id.progressBar)

            // using dispatcher + lifecycle scope to update the ui on the main thread to allow for a smoother user experience
            if (counter == 0)
            {
                lifecycleScope.launch(Dispatchers.Main) {
                    progressBar.visibility = View.VISIBLE
                }
            }
            if (query.isEmpty()) {
                // Load default cities (Australia cities in this case)
                loadDefaultCities()
            } else {
                // Search for cities starting with the query
                searchCities(query)
            }
            counter = 1
        }
    }
}

