package com.example.weather_app_takes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import android.view.View


class MainActivity : AppCompatActivity() {

    val API: String = "d1a60da1c7934bf6b6764013232410"

    object RetrofitInstance {
        private const val BASE_URL = "http://api.weatherapi.com/"

        val weatherApi: WeatherApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
        }
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
                    weatherData1.temp_c.toString(),  // Convert temp_c to String
                    weatherData1.condition.icon,
                )
                weatherList.add(weatherModal)
            } catch (e: Exception) {
                // Handle network error
                Log.e("Network Error", e.message ?: "Unknown error")
                e.printStackTrace()
            }
        }
        return weatherList
    }
    private fun updateUIWithWeatherData(weatherList: MutableList<WeatherModal>) {
        if (::weatherAdapter.isInitialized) {
            weatherAdapter.updateList(weatherList)
        } else {
            weatherAdapter = WeatherAdapter(weatherList)
            groupRecyclerView.adapter = weatherAdapter
        }
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
        updateUIWithWeatherData(citiesData)
    }

    private suspend fun searchCities(query: String) {
        val matchedCities = CityList.cities.filter { it.startsWith(query, ignoreCase = true) }.take(10)
        val citiesData = getWeatherDataFromAPI(matchedCities)
        // remove the progress bar
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.GONE
        // Update the RecyclerView

        updateUIWithWeatherData(citiesData)

    }

    private fun performSearch(query: String) {
        lifecycleScope.launch {
            // make progress bar visible
            progressBar = findViewById(R.id.progressBar)
            progressBar.visibility = View.VISIBLE

            if (query.isEmpty()) {
                // Load default cities (Australia cities in this case)
                loadDefaultCities()
            } else {
                // Search for cities starting with the query
                searchCities(query)
            }
        }
    }

    // Declare RecyclerView and data list variables
    private lateinit var groupRecyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupRecyclerView = findViewById(R.id.recyclerView)
        groupRecyclerView.layoutManager = LinearLayoutManager(this)
        groupRecyclerView.setHasFixedSize(true)
        performSearch("")
        val searchBar = findViewById<SearchView>(R.id.SearchBar)
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle when the search button is pressed (or Enter key)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle as the text changes
                performSearch(newText ?: "")
                return true
            }
        })
    }

}
