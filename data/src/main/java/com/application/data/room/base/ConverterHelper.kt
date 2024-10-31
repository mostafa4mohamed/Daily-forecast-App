package com.application.data.room.base

import androidx.room.TypeConverter
import com.application.data.room.entity.CloudsRoomEntity
import com.application.data.room.entity.MainRoomEntity
import com.application.data.room.entity.SysRoomEntity
import com.application.data.room.entity.WeatherRoomEntity
import com.application.data.room.entity.WindRoomEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ConverterHelper {

    @TypeConverter
    fun fromClouds(clouds: CloudsRoomEntity?): String? {
        if (clouds == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(clouds, clouds::class.java)
    }

    @TypeConverter
    fun toClouds(josnString: String?): CloudsRoomEntity? {
        if (josnString == null) {
            return null
        }
        val gson = Gson()
        return gson.fromJson(josnString, CloudsRoomEntity::class.java)
    }

    @TypeConverter
    fun fromMain(main: MainRoomEntity?): String? {
        if (main == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(main, main::class.java)
    }

    @TypeConverter
    fun toMain(josnString: String?): MainRoomEntity? {
        if (josnString == null) {
            return null
        }
        val gson = Gson()
        return gson.fromJson(josnString, MainRoomEntity::class.java)
    }

    @TypeConverter
    fun fromSys(sys: SysRoomEntity?): String? {
        if (sys == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(sys, sys::class.java)
    }

    @TypeConverter
    fun toSys(josnString: String?): SysRoomEntity? {
        if (josnString == null) {
            return null
        }
        val gson = Gson()
        return gson.fromJson(josnString, SysRoomEntity::class.java)
    }

    @TypeConverter
    fun fromWind(wind: WindRoomEntity?): String? {
        if (wind == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(wind, wind::class.java)
    }

    @TypeConverter
    fun toWind(josnString: String?): WindRoomEntity? {
        if (josnString == null) {
            return null
        }
        val gson = Gson()
        return gson.fromJson(josnString, WindRoomEntity::class.java)
    }

    @TypeConverter
    fun fromListWeather(list: List<WeatherRoomEntity>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(list, List::class.java)
    }

    @TypeConverter
    fun toListWeather(josnString: String?): List<WeatherRoomEntity>? {
        if (josnString == null) {
            return null
        }
        val gson = Gson()
        val listType: Type =
            object : TypeToken<List<WeatherRoomEntity?>?>() {}.type
        return gson.fromJson<List<WeatherRoomEntity>>(josnString, listType)
    }

}