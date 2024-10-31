package com.application.dailyforecast.ui

import androidx.lifecycle.viewModelScope
import com.application.dailyforecast.base.BaseViewModel
import com.application.dailyforecast.utils.NetworkState
import com.application.domain.entities.CitiesModel
import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import com.application.domain.use_cases.GetDailyForecastByCityUseCase
import com.application.domain.use_cases.GetLocalCitiesUseCase
import com.application.domain.use_cases.InsertDailyForecastByCityInRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDailyForecastByCityUseCase: GetDailyForecastByCityUseCase,
    private val insertDailyForecastByCityInRoomUseCase: InsertDailyForecastByCityInRoomUseCase,
    private val getLocalCitiesUseCase: GetLocalCitiesUseCase
) :
    BaseViewModel() {

    private val _getDailyForecastStateFlow =
        MutableStateFlow<NetworkState<DailyForecastResponse?>>(NetworkState.Idle)
    val getDailyForecastStateFlow get() = _getDailyForecastStateFlow

    private val _getCitiesStateFlow =
        MutableStateFlow<NetworkState<CitiesModel>>(NetworkState.Idle)
    val getCitiesStateFlow get() = _getCitiesStateFlow

    fun getDailyForecastByCity(
        cityId: Int,
        latitude: Double,
        longitude: Double,
    ) {

        _getDailyForecastStateFlow.value = NetworkState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                getDailyForecastByCityUseCase.invokeFromRemote(
                    latitude,
                    longitude
                )
            }.onFailure { th ->
                _getDailyForecastStateFlow.value = NetworkState.Error(msg = th.message)
            }.onSuccess {

                val isOnline: Boolean
                val data: DailyForecastResponse?

                if (it != null) {
                    isOnline = true
                    saveAtRoom(cityId, it.list)
                    data = it
                } else {

                    try {
                        isOnline = false
                        data = invokeFromRoom(cityId)

                    } catch (e: Exception) {
                        _getDailyForecastStateFlow.value = NetworkState.Error(msg = e.message)
                        return@onSuccess
                    }

                }

                _getDailyForecastStateFlow.value = NetworkState.Result(data, isOnline)

            }
        }
    }

    private suspend fun saveAtRoom(cityId: Int, list: List<DailyForecastData>?) {

        if (list.isNullOrEmpty()) return

        val data: List<DailyForecastData> = list.map {
            it.city_id = cityId
            it
        }

        insertDailyForecastByCityInRoomUseCase.insertData(data)
    }

    private suspend fun invokeFromRoom(cityId: Int) =
        getDailyForecastByCityUseCase.invokeFromLocalData(cityId)

    fun getLocalCities() {
        _getCitiesStateFlow.value = NetworkState.Result(getLocalCitiesUseCase.invoke()!!)
    }

}