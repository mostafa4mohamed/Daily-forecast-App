package com.application.data.impl

import android.content.Context
import com.application.data.local.CitiesParser
import com.application.domain.entities.CitiesModel
import com.application.domain.repo.LocalCitiesRepo

class LocalCitiesRepoImpl(
    private val context: Context, private val parser: CitiesParser
) : LocalCitiesRepo {

    override fun getLocalCities(): CitiesModel? = parser.getLocalCities(context)

}