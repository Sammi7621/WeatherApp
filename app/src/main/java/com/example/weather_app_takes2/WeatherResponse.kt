package com.example.weather_app_takes2

data class WeatherResponse(
    val location: Location,
    val current: Current
) {
    data class Location(
        val name: String,
        val country: String,
        val localtime: String
    )

    data class Current(
        val temp_c: Double,
        val condition: Condition,
    ) {
        data class Condition(
            val icon: String
        )
    }
}
