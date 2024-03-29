package com.example.data.di


import com.example.data.repository.HomeRepositoryImpl
import com.example.data.repository.MealDetailsRepositoryImpl
import com.example.data.repository.TopCategoryRepositoryImpl
import com.example.domain.repository.HomeRepository
import com.example.domain.repository.MealDetailsRepository
import com.example.domain.repository.TopCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun provideMealDetailsRepository(mealDetailsRepositoryImpl: MealDetailsRepositoryImpl): MealDetailsRepository

    @Binds
    @Singleton
    abstract fun provideTopCategoryRepository(topCategoryRepositoryImpl: TopCategoryRepositoryImpl): TopCategoryRepository

}