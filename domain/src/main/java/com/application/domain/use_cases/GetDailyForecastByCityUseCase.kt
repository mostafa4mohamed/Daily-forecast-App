package com.application.domain.use_cases

import com.application.domain.repo.DailyForecastRepo

class GetDailyForecastByCityUseCase (private val repo: DailyForecastRepo) {

    suspend fun invokeFromRemote(
        latitude: Double,
        longitude: Double,
    ) = repo.getDailyForecastByCityFromRemote(latitude, longitude)

    suspend fun invokeFromLocalData(
        cityId:Int,
    ) = repo.getDailyForecastByCityFromLocalDataBase(cityId)

}