package com.example.weather_app_takes2

class WeatherModal(
    private var _time: String,
    private var _temperature: String,
    private var _icon: String,
    private var _windspeed: String,
    private var _feelslike: String,
    private var _condition: String
) {

    var time: String
        get() = _time
        set(value) {
            _time = value
        }

    var temperature: String
        get() = _temperature
        set(value) {
            _temperature = value
        }

    var icon: String
        get() = _icon
        set(value) {
            _icon = value
        }

    var windspeed: String
        get() = _windspeed
        set(value) {
            _windspeed = value
        }

    var feelslike: String
        get() = _feelslike
        set(value) {
            _feelslike = value
        }

    var condition: String
        get() = _condition
        set(value) {
            _condition = value
        }

}