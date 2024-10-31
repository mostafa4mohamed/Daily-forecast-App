package com.application.dailyforecast.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.dailyforecast.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() :
    ViewModel() {

    fun <T> runApi(
        apiStateFlow: MutableStateFlow<NetworkState<T>>,
        block: suspend () -> T
    ) {

        apiStateFlow.value = NetworkState.Loading
        try {
            viewModelScope.launch {

                kotlin.runCatching {
                    block()
                }.onFailure { th ->
                    apiStateFlow.value = NetworkState.Error(msg = th.message)
                }.onSuccess {

                    try {
                        apiStateFlow.value = NetworkState.Result(it)
                    } catch (e: Exception) {
                        apiStateFlow.value = NetworkState.Error(msg = e.message)
                    }
                }

            }
        } catch (e: Exception) {
            apiStateFlow.value = NetworkState.Error(msg = e.message)
        }


    }

    companion object {
        private const val TAG = "BaseViewModel"
    }

}