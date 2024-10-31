package com.application.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.application.data.room.entity.DailyForecastRoomEntity

@Dao
interface DailyForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: List<DailyForecastRoomEntity>)

    @Query("SELECT * FROM DailyForecastRoomEntity WHERE city_id = :cityId")
    suspend fun getDailyForecastByCity(cityId: Int): List<DailyForecastRoomEntity>
}