package com.example.data.repository

import com.example.data.mapper.mapToDomain
import com.example.data.remote.RemoteDataSource
import com.example.domain.model.HomeResponse
import com.example.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    HomeRepository {
    override suspend fun getHome(): Flow<HomeResponse> {
        return flow {
            val response = remoteDataSource.getHome()
            if (response.isSuccessful) {
                val body = response.body()
                body?.mapToDomain()?.let { emit(it) }
            }
        }
    }


}