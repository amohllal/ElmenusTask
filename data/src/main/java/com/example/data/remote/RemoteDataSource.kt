package com.example.data.remote

import com.example.data.core.HOME_BASE
import com.example.data.core.MEALS_BASE
import javax.inject.Named

class RemoteDataSource(
    @Named(HOME_BASE) private val homeApiService: ApiService,
    @Named(MEALS_BASE) private val mealsApiService: ApiService
) {

    suspend fun getHome() = homeApiService.getHome()

    suspend fun getMealDetails(mealId: String) = mealsApiService.getMealDetails(mealId)

    suspend fun getTopCategory(category: String) = mealsApiService.getTopCategory(category)


}