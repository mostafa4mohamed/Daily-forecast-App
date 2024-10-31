package com.application.dailyforecast.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext

sealed class NetworkState<out T> {

    //idle
    object Idle : NetworkState<Nothing>()

    //loading
    data object Loading : NetworkState<Nothing>()

    //result
    data class Result<D>(var response: D,val onlineState:Boolean?=null) : NetworkState<D>()

    //error
    data class Error(var errorCode: Int?=null, var msg: String? = null) : NetworkState<Nothing>() {

        fun handleErrors(
            @ApplicationContext
            mContext: Context,
        ) {

            Log.e(TAG, "handleErrors: msg $msg")
            Log.e(TAG, "handleErrors: error code $errorCode")

            Toast.makeText(mContext, msg ?: "known_error", Toast.LENGTH_SHORT).show()
        }

        companion object {
            private val TAG = this::class.java.name
        }

    }

}
