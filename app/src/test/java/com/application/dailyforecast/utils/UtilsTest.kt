package com.application.dailyforecast.utils

import com.application.dailyforecast.utils.Utils.convertFromKelvinToCelsius
import com.application.dailyforecast.utils.Utils.format2Digits
import org.junit.Assert.*

import org.junit.Test

class UtilsTest {


    @Test
    fun convertFromKelvinToCelsius() {

        val result = 280.15.convertFromKelvinToCelsius()

        val expected = 7.0

        assert(result == expected)

    }

    @Test
    fun `format2Digits return data`() {


        val result = 33.12345.format2Digits()

        val expected = 33.12.toString()

        assert(result == expected)

    }

    @Test
    fun `format2Digits with null data`() {

        val input: Double? = null
        val result = input.format2Digits()

        assert(result.isEmpty())

    }
}