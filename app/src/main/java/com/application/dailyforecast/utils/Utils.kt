package com.application.dailyforecast.utils

import java.net.InetAddress
import java.util.Locale

object Utils {

    fun isInternetAvailable(): Boolean {
        return try {
            val ipAddr: InetAddress = InetAddress.getByName("google.com")
            //You can replace it with your name
            !ipAddr.equals("")
        } catch (e: Exception) {
            false
        }
    }

    fun Double.convertFromKelvinToCelsius(): Double = this - 273.15

    fun Double?.format2Digits(): String =
        if (this == null) ""
        else String.format(Locale.ENGLISH, "%.2f", this)

}