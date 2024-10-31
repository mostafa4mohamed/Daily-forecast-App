package com.application.dailyforecast.di

import android.content.Context
import com.application.data.local.DailyForecastDao
import com.application.data.room.base.RoomManger
import com.application.data.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {


    @Singleton
    @Provides
    fun provideMainDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RoomManger::class.java,
        Constants.DB_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideDailyForecastDao(db: RoomManger): DailyForecastDao = db.dailyForecastDao()
}