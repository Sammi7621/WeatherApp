package com.example.weather_app_takes2

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date
interface WeatherApi {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("aqi") aqi: String,
        @Query("timestamp") timestamp: Long = Date().time // trick the program so that the data wont be stored the cache
    ): WeatherResponse

    @GET("v1/forecast.json")
    suspend fun getCurrentWeatherForecast(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("aqi") aqi: String,
        @Query("timestamp") timestamp: Long = Date().time // trick the program so that the data wont be stored the cache
    ): WeatherResponse24Hours
}
