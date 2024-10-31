package com.application.data.impl

import com.application.data.local.DailyForecastDao
import com.application.data.mapper.DailyForecastMapper.toDomainEntity
import com.application.data.mapper.DailyForecastMapper.toRoomEntity
import com.application.data.remote.DailyForecastServices
import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import com.application.domain.repo.DailyForecastRepo

class DailyForecastRepoImpl(
    private val apis: DailyForecastServices,
    private val dao: DailyForecastDao
) : DailyForecastRepo {

    override suspend fun getDailyForecastByCityFromRemote(
        latitude: Double,
        longitude: Double,
    ): DailyForecastResponse =
        apis.getDailyForecastByCityFromRemote(latitude, longitude)

    override suspend fun getDailyForecastByCityFromLocalDataBase(
        cityId: Int
    ): DailyForecastResponse =
        DailyForecastResponse(list = dao.getDailyForecastByCity(cityId).map { it.toDomainEntity() })

    override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
        dao.insert(data.map { it.toRoomEntity() })
    }


}