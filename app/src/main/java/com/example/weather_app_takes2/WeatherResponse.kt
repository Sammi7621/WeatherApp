package com.example.weather_app_takes2

data class WeatherResponse(
    val current: Current
) {
    data class Current(
        val last_updated: String,
        val temp_c: String,
        val condition: Condition,
        val wind_kph: String,
        val feelslike_c: String,
    ) {
        data class Condition(
            val icon: String
        )
    }
}

