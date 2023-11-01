package com.example.weather_app_takes2

data class WeatherResponse24Hours (
    val location: Location,
    val current: Current,
    val forecast: Forecast // Use List<> instead of Forecast object
) {
    data class Location(
        val name: String,
        val country: String,
        val localtime: String
    )

    data class Current(
        val temp_c: Double,
        val temp_f: Double,
        val condition: Condition,
        val wind_kph: Double,
        val uv: Double,
        val humidity: Double,
        val precip_mm: Double
    ) {
        data class Condition(
            val icon: String
        )
    }

    data class Forecast(
        val forecastday: MutableList<ForecastDay>
    ) {
        data class ForecastDay(
            val day: DayData,
            val astro: Astro,
            val hour: MutableList<Hour> // Use List<> instead of MutableList<> here
        ) {
            data class DayData(
                val maxtemp_c: Double,
                val mintemp_c: Double,
                val avgtemp_c: Double,
                val daily_chance_of_rain: Int
            )

            data class Astro(
                val sunrise: String,
                val sunset: String
            )

            data class Hour(
                val time: String,
                val temp_c: Double,
                val condition: Condition
            ) {
                data class Condition(
                    val icon: String
                )
            }
        }
    }
}
