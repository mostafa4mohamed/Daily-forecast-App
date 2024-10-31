package com.application.data.remote

import com.application.data.utils.Constants
import com.application.domain.entities.DailyForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DailyForecastServices {

    @GET("forecast")
    suspend fun getDailyForecastByCityFromRemote(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("APPID") appId: String = Constants.DAILY_FORECAST_APP_ID
    ): DailyForecastResponse

}