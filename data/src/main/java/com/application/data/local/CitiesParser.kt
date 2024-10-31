package com.application.data.local

import android.content.Context
import com.application.data.R
import com.application.domain.entities.CitiesModel
import com.google.gson.Gson
import java.io.IOException
import javax.inject.Inject

class CitiesParser @Inject constructor() {

    fun getLocalCities(context: Context): CitiesModel? {

        lateinit var jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.cities)
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            return CitiesModel()
        }

        val classType = CitiesModel::class.java

        return Gson().fromJson(jsonString, classType)
    }

}