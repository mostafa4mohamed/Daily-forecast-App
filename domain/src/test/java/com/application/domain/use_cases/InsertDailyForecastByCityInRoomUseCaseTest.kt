package com.application.domain.use_cases

import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import com.application.domain.repo.DailyForecastRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

class InsertDailyForecastByCityInRoomUseCaseTest {


    @Test(expected = UnsupportedOperationException::class)
    fun `insertData return Exception`() = runBlocking {

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                latitude: Double,
                longitude: Double
            ): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityId: Int): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                throw UnsupportedOperationException()
            }

        }
        val useCase = InsertDailyForecastByCityInRoomUseCase(repo)

        //act
        val result = useCase.insertData(emptyList())

        //assert
        assertNull(result)
    }

    @Test
    fun `invokeFromLocalData return success`() = runBlocking {

        var action=true

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                latitude: Double,
                longitude: Double
            ): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityId: Int): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                action=true
            }

        }
        val useCase = InsertDailyForecastByCityInRoomUseCase(repo)

        //act
        useCase.insertData(emptyList())

        //assert
        assert(action)

    }

    @Test
    fun `invokeFromLocalData return false`() = runBlocking {

        var action=true

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                latitude: Double,
                longitude: Double
            ): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityId: Int): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                action=false
            }

        }
        val useCase = InsertDailyForecastByCityInRoomUseCase(repo)

        //act
        useCase.insertData(emptyList())

        //assert
        assert(!action)

    }

}