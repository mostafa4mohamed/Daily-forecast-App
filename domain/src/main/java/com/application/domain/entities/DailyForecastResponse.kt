package com.application.domain.entities

data class DailyForecastResponse(
    var city: City? = null,
    var cnt: Int? = null,
    var cod: String? = "200",
    var list: List<DailyForecastData>? = null,
    var message: Int? = null
)

data class City(
    var id: Int,
    var name: String,
    var coord: Coord?,
    var country: String,
    var population: Int,
    var sunrise: Int,
    var sunset: Int,
    var timezone: Int
)

data class DailyForecastData(
    var city_id: Int? = null,
    val clouds: Clouds? = null,
    val dt: Int? = null,
    val dt_txt: String? = null,
    val main: Main? = null,
    val pop: Float? = null,
    val sys: Sys? = null,
    val visibility: Int? = null,
    val weather: List<Weather>? = null,
    val wind: Wind? = null
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Clouds(
    val all: Int
)

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class Sys(
    val pod: String
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Double,
    val main: String
)

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)