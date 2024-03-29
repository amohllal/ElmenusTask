package com.example.data.repository

import com.example.data.entity.TopCategoryEntity
import com.example.data.mapper.mapToDomain
import com.example.data.mapper.mapToEntity
import com.example.data.model.topcategory.TopCategoryDTO
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.domain.model.TopCategoryResponse
import com.example.domain.repository.TopCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopCategoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    TopCategoryRepository {

    override suspend fun getTopCategory(category: String): Flow<TopCategoryResponse> {
        return flow {
            val response = remoteDataSource.getTopCategory(category)
            if (response.isSuccessful) {
                val body = response.body()
                mapRemoteResponseToDomain(body)?.let { emit(it) }
                mapRemoteResponseToLocalStorage(body)?.let { localDataSource.saveTopCategory(it) }
            } else {
                emit(mapLocalResponseToDomain(localDataSource.getTopCategory()))
            }
        }
    }

    private fun mapRemoteResponseToDomain(topCategoryDTO: TopCategoryDTO?) =
        topCategoryDTO?.mapToDomain()


    private fun mapRemoteResponseToLocalStorage(topCategoryDTO: TopCategoryDTO?) =
        topCategoryDTO?.mapToEntity()


    private fun mapLocalResponseToDomain(topCategoryEntity: TopCategoryEntity) =
        topCategoryEntity.mapToDomain()


}