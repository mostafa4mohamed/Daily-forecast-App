package com.application.data.mapper

import com.application.data.room.entity.CloudsRoomEntity
import com.application.data.room.entity.DailyForecastRoomEntity
import com.application.data.room.entity.MainRoomEntity
import com.application.data.room.entity.SysRoomEntity
import com.application.data.room.entity.WeatherRoomEntity
import com.application.data.room.entity.WindRoomEntity
import com.application.domain.entities.Clouds
import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.Main
import com.application.domain.entities.Sys
import com.application.domain.entities.Weather
import com.application.domain.entities.Wind

object DailyForecastMapper {

    fun DailyForecastData.toRoomEntity() = DailyForecastRoomEntity(
        city_id = this.city_id ?: 0,
        clouds = if (this.clouds != null) CloudsRoomEntity(this.clouds!!.all) else null,
        dt = this.dt ?: 0,
        dt_txt = this.dt_txt,
        main = if (this.main != null) MainRoomEntity(
            this.main!!.feels_like,
            this.main!!.grnd_level,
            this.main!!.humidity,
            this.main!!.pressure,
            this.main!!.sea_level,
            this.main!!.temp,
            this.main!!.temp_kf,
            this.main!!.temp_max,
            this.main!!.temp_min,
        ) else null,
        pop = this.pop,
        sys = if (this.sys != null) SysRoomEntity(this.sys!!.pod) else null,
        visibility = this.visibility,
        weather = this.weather?.map { w ->
            WeatherRoomEntity(
                w.description,
                w.icon,
                w.id,
                w.main,
            )
        },
        wind = if (this.wind != null) WindRoomEntity(
            this.wind!!.deg,
            this.wind!!.gust,
            this.wind!!.speed,
        ) else null,
    )

    fun DailyForecastRoomEntity.toDomainEntity() = DailyForecastData(
        city_id = this.city_id,
        clouds = if (this.clouds != null) Clouds(this.clouds.all) else null,
        dt = this.dt,
        dt_txt = this.dt_txt,
        main = if (this.main != null) Main(
            this.main.feels_like,
            this.main.grnd_level,
            this.main.humidity,
            this.main.pressure,
            this.main.sea_level,
            this.main.temp,
            this.main.temp_kf,
            this.main.temp_max,
            this.main.temp_min,
        ) else null,
        pop = this.pop,
        sys = if (this.sys != null) Sys(this.sys.pod) else null,
        visibility = this.visibility,
        weather = this.weather?.map { w ->
            Weather(
                w.description,
                w.icon,
                w.id,
                w.main,
            )
        },
        wind = if (this.wind != null) Wind(
            this.wind.deg,
            this.wind.gust,
            this.wind.speed,
        ) else null,
    )

}