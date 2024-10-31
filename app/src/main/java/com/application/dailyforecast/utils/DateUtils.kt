package com.application.dailyforecast.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtils {

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm a", Locale.ENGLISH)
    private val dateFullFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)

    fun String?.dateFormat(): String? {

        if (this.isNullOrEmpty()) return null

        val parsed = try {
            dateFullFormat.parse(this)
        } catch (e: Exception) {
            dateFormat.parse(this)
        }

        return dateFormat.format(parsed!!)

    }

}