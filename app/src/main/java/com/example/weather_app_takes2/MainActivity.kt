package com.example.weather_app_takes2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //delcare displayed cities
    private val australiaCity = mutableListOf(
        "Melbourne",
        "Brisbane",
        "Perth",
        "Tasmania",
        "Sydney"
    )

    // Declare RecyclerView and data list variables
    private lateinit var groupRecyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter

    val city: String = "Melbourne, Au"
    val API: String = "d1a60da1c7934bf6b6764013232410"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = mutableListOf<Group>()
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))
        list.add(Group("Melbourne","16","12:00","idk"))


        // Initialize the RecyclerView
        groupRecyclerView = findViewById(R.id.recyclerView)
        groupRecyclerView.layoutManager = LinearLayoutManager(this) // Set the layout manager to display items in a vertical list
        groupRecyclerView.setHasFixedSize(true) // Optimizes the RecyclerView if its size doesn't change

        // Initialize the WeatherAdapter with the list and set it to the RecyclerView
        weatherAdapter = WeatherAdapter(list)
        groupRecyclerView.adapter = weatherAdapter
    }

}
