package com.example.weather_app_takes2

class WeatherModal(
    private var _city: String,
    private var _time: String,
    private var _temperature: String,
    private var _icon: String,
) {

    var time: String
        get() = _time
        set(value) {
            _time = value
        }
    var city: String
        get() = _city
        set(value) {
            _city = value
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


}