package com.example.domain.repository

import com.example.domain.model.TopCategoryResponse
import kotlinx.coroutines.flow.Flow

interface TopCategoryRepository {
    suspend fun getTopCategory(category: String): Flow<TopCategoryResponse>

}