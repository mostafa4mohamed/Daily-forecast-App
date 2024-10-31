package com.application.dailyforecast.utils

import com.application.dailyforecast.utils.DateUtils.dateFormat
import org.junit.Assert.*
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `dateFormat with valid data and return true`() {

        val result = "2011-11-11 11:11:11".dateFormat()

        val expected = "11/11/2011 11:11 AM"

        assertEquals(expected, result)
    }

    @Test
    fun `dateFormat with valid data and return false`() {

        val result = "2011-11-11 11:11:11".dateFormat()

        val expected = "11/11/2001 11:11 AM"

        assertNotEquals(expected, result)
    }

    @Test
    fun `dateFormat with null data`() {

        val result = null.dateFormat()

        assertNull(result)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `dateFormat with invalid data`() {

        val result: String?
        try {
            result = "test".dateFormat()
        } catch (e: Exception) {
            throw UnsupportedOperationException()
        }

        assertNull(result)
    }


}