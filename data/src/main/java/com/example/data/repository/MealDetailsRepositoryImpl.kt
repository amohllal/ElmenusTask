package com.example.data.repository

import com.example.data.mapper.mapToDomain
import com.example.data.remote.RemoteDataSource
import com.example.domain.model.MealResponse
import com.example.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealDetailsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    MealDetailsRepository {

    override suspend fun getMealDetails(mealId: String): Flow<MealResponse> {
        return flow {
            val response = remoteDataSource.getMealDetails(mealId)
            if (response.isSuccessful) {
                val body = response.body()
                body?.mapToDomain()?.let { emit(it) }
            }
        }
    }


}