package com.example.domain.repository

import com.example.domain.model.MealResponse
import kotlinx.coroutines.flow.Flow

interface MealDetailsRepository {
    suspend fun getMealDetails(mealId : String): Flow<MealResponse>
}