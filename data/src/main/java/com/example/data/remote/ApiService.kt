package com.example.data.remote

import com.example.data.core.CATEGORY_DETAILS_END_POINT
import com.example.data.core.CATEGORY_DETAILS_END_POINT_QUERY
import com.example.data.core.HOME_END_POINT
import com.example.data.core.MEALS_DETAILS_END_POINT
import com.example.data.core.MEALS_DETAILS_END_POINT_QUERY
import com.example.data.model.home.HomeDTO
import com.example.data.model.meal.MealsDetailsDTO
import com.example.data.model.topcategory.TopCategoryDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(HOME_END_POINT)
    suspend fun getHome(): Response<HomeDTO>

    @GET(MEALS_DETAILS_END_POINT)
    suspend fun getMealDetails(@Query(MEALS_DETAILS_END_POINT_QUERY) mealId: String): Response<MealsDetailsDTO>

    @GET(CATEGORY_DETAILS_END_POINT)
    suspend fun getTopCategory(@Query(CATEGORY_DETAILS_END_POINT_QUERY) category: String): Response<TopCategoryDTO>
}