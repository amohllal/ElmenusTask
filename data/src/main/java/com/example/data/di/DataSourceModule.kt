package com.example.data.di

import javax.inject.Named
import com.example.data.core.HOME_BASE
import com.example.data.core.MEALS_BASE
import com.example.data.local.ElmenusDAO
import com.example.data.remote.ApiService
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        @Named(HOME_BASE) homeApiService: ApiService,
        @Named(MEALS_BASE) mealsApiService: ApiService
    ): RemoteDataSource {
        return RemoteDataSource(homeApiService, mealsApiService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        elmenusDAO: ElmenusDAO
    ): LocalDataSource {
        return LocalDataSource(elmenusDAO)
    }
}