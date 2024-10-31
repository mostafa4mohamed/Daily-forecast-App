package com.application.data.room.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.application.data.local.DailyForecastDao
import com.application.data.room.entity.DailyForecastRoomEntity
import com.application.domain.entities.DailyForecastData

@Database(
    entities = [DailyForecastRoomEntity::class],
    version = 3,
    exportSchema = false,
)
@TypeConverters(ConverterHelper::class)
abstract class RoomManger : RoomDatabase() {

    abstract fun dailyForecastDao(): DailyForecastDao

}