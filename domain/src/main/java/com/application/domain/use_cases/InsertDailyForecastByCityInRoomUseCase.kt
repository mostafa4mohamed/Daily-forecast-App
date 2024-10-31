package com.application.domain.use_cases

import com.application.domain.entities.DailyForecastData
import com.application.domain.repo.DailyForecastRepo

class InsertDailyForecastByCityInRoomUseCase (private val repo: DailyForecastRepo) {

    suspend fun insertData(
        data: List<DailyForecastData>
    ) = repo.insertDailyForecastByCityToLocalDataBase(data)

}