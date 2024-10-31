package com.application.data.room.entity

import androidx.room.*


@Entity(primaryKeys = ["city_id", "dt"])
data class DailyForecastRoomEntity(
    @ColumnInfo var city_id: Int = 0,
    @ColumnInfo val clouds: CloudsRoomEntity? = null,
    @ColumnInfo val dt: Int = 0,
    @ColumnInfo val dt_txt: String? = null,
    @ColumnInfo val main: MainRoomEntity? = null,
    @ColumnInfo val pop: Float? = null,
    @ColumnInfo val sys: SysRoomEntity? = null,
    @ColumnInfo val visibility: Int? = null,
    @ColumnInfo val weather: List<WeatherRoomEntity>? = null,
    @ColumnInfo val wind: WindRoomEntity? = null
)

data class CloudsRoomEntity(
    val all: Int
)

data class MainRoomEntity(
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

data class SysRoomEntity(
    val pod: String
)

data class WeatherRoomEntity(
    val description: String,
    val icon: String,
    val id: Double,
    val main: String
)

data class WindRoomEntity(
    val deg: Int,
    val gust: Double,
    val speed: Double
)