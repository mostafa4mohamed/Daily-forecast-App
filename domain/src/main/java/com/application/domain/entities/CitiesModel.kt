package com.application.domain.entities

data class CitiesModel(
    val cities: List<City> = emptyList()
) {

    data class City(
        val cityNameAr: String,
        val cityNameEn: String,
        val id: Int,
        val lat: Double,
        val lon: Double
    )
}
