package com.application.dailyforecast.di

import android.content.Context
import com.application.data.impl.DailyForecastRepoImpl
import com.application.data.impl.LocalCitiesRepoImpl
import com.application.data.local.CitiesParser
import com.application.data.local.DailyForecastDao
import com.application.data.remote.DailyForecastServices
import com.application.domain.repo.DailyForecastRepo
import com.application.domain.repo.LocalCitiesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideGetDailyForecastRepo(apiServices: DailyForecastServices,dao: DailyForecastDao): DailyForecastRepo =
        DailyForecastRepoImpl(apiServices,dao)

    @Singleton
    @Provides
    fun provideCitiesParser(): CitiesParser = CitiesParser()

    @Provides
    fun provideLocalCitiesRepo(
        @ApplicationContext context: Context,
        citiesParser: CitiesParser
    ): LocalCitiesRepo =
        LocalCitiesRepoImpl(context, citiesParser)

}