package com.example.data.repository

import com.example.data.mapper.mapToDomain
import com.example.data.remote.RemoteDataSource
import com.example.domain.model.TopCategoryResponse
import com.example.domain.repository.TopCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopCategoryRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    TopCategoryRepository {

    override suspend fun getTopCategory(category: String): Flow<TopCategoryResponse> {
        return flow {
            val response = remoteDataSource.getTopCategory(category)
            if (response.isSuccessful) {
                val body = response.body()
                body?.mapToDomain()?.let { emit(it) }
            }
        }
    }


}