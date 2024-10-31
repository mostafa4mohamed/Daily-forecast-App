package com.application.domain.repo

import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse

interface DailyForecastRepo {

    suspend fun getDailyForecastByCityFromRemote(
        latitude: Double,
        longitude: Double,
    ): DailyForecastResponse?

    suspend fun getDailyForecastByCityFromLocalDataBase(
        cityId: Int,
    ): DailyForecastResponse?

    suspend fun insertDailyForecastByCityToLocalDataBase(
        data: List<DailyForecastData>
    )

}