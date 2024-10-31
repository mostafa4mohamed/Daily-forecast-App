package com.application.domain.use_cases

import com.application.domain.entities.CitiesModel
import com.application.domain.repo.LocalCitiesRepo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test


class GetLocalCitiesUseCaseTest {

    @Test
    fun `getLocalCities return data`() {

        val list = CitiesModel()

        //arrange
        val repo = object : LocalCitiesRepo {
            override fun getLocalCities(): CitiesModel {
                return list
            }
        }
        val useCase = GetLocalCitiesUseCase(repo)

        //act
        val result = useCase.invoke()

        //assert
        val expected = list
        assertEquals(expected, result)

    }

    @Test
    fun `getLocalCities return null`() {

        //arrange
        val repo = object : LocalCitiesRepo {
            override fun getLocalCities(): CitiesModel? {
                return null
            }
        }
        val useCase = GetLocalCitiesUseCase(repo)

        //act
        val result = useCase.invoke()

        //assert
        assertNull(result)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `getLocalCities return Exception`() {

        //arrange
        val repo = object : LocalCitiesRepo {
            override fun getLocalCities(): CitiesModel {
                throw UnsupportedOperationException()
            }
        }
        val useCase = GetLocalCitiesUseCase(repo)

        //act
        val result = useCase.invoke()

        //assert
        assertNull(result)

    }

}