package com.example.data.source

import com.example.data.core.HOME_BASE
import com.example.data.core.MEALS_BASE
import com.example.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Named

class RemoteDataSource @Inject constructor(
    @Named(HOME_BASE) private val homeApiService: ApiService,
    @Named(MEALS_BASE) private val mealsApiService: ApiService
) {

    suspend fun getHome() = homeApiService.getHome()

    suspend fun getMealDetails(mealId: String) = mealsApiService.getMealDetails(mealId)

    suspend fun getTopCategory(category: String) = mealsApiService.getTopCategory(category)


}