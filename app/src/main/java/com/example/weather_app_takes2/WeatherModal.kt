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

class HourModal(
    private var _time: String,
    private var _temperature: String,
    private var _icon: String,
    private var _wind_kph: String,
    private var _uv: String,
    private var _humidity: String,
    private var _precip_mm: String,
    private var _maxtemp_c: String,
    private var _mintemp_c: String,
    private var _avgtemp_c: String,
    private var _hours: MutableList<Hour>
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

    var wind_kph: String
        get() = _wind_kph
        set(value) {
            _wind_kph = value
        }

    var uv: String
        get() = _uv
        set(value) {
            _uv = value
        }

    var humidity: String
        get() = _humidity
        set(value) {
            _humidity = value
        }

    var precip_mm: String
        get() = _precip_mm
        set(value) {
            _precip_mm = value
        }
    var mintemp_c: String
        get() = _mintemp_c
        set(value) {
            _mintemp_c = value
        }

    var avgtemp_c: String
        get() = _avgtemp_c
        set(value) {
            _avgtemp_c = value
        }

    var maxtemp_c: String
        get() = _maxtemp_c
        set(value) {
            _maxtemp_c = value
        }

    var hours: MutableList<Hour>
        get() = _hours
        set(value) {
            _hours = value
        }
}

class Hour(
    private var _time: String,
    private var _temperature: String,
    private var _icon: String
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
}
