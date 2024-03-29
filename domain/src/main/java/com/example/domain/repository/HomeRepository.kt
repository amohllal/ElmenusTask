package com.example.domain.repository

import com.example.domain.model.HomeResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHome(): Flow<HomeResponse>
}