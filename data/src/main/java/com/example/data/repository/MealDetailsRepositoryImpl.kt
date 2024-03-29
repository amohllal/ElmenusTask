package com.example.data.repository

import com.example.data.entity.MealEntity
import com.example.data.mapper.mapToDomain
import com.example.data.mapper.mapToEntity
import com.example.data.model.meal.MealsDetailsDTO
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.domain.model.MealResponse
import com.example.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    MealDetailsRepository {

    override suspend fun getMealDetails(mealId: String): Flow<MealResponse> {
        return flow {
            val response = remoteDataSource.getMealDetails(mealId)
            if (response.isSuccessful) {
                val body = response.body()
                mapRemoteResponseToDomain(body)?.let { emit(it) }
                mapRemoteResponseToLocalStorage(body)?.let { localDataSource.saveMeal(it) }
            } else {
                emit(mapLocalResponseToDomain(localDataSource.getMeal()))
            }
        }
    }

    private fun mapRemoteResponseToDomain(mealsDetailsDTO: MealsDetailsDTO?) =
        mealsDetailsDTO?.mapToDomain()


    private fun mapRemoteResponseToLocalStorage(mealsDetailsDTO: MealsDetailsDTO?) =
        mealsDetailsDTO?.mapToEntity()


    private fun mapLocalResponseToDomain(mealEntity: MealEntity) = mealEntity.mapToDomain()


}