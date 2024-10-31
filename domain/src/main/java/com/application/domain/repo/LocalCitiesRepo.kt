package com.application.domain.repo

import com.application.domain.entities.CitiesModel

interface LocalCitiesRepo {

    fun getLocalCities(): CitiesModel?

}