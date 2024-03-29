package com.example.data.repository

import com.example.data.entity.HomeEntity
import com.example.data.mapper.mapToDomain
import com.example.data.mapper.mapToEntity
import com.example.data.model.home.HomeDTO
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.domain.model.HomeResponse
import com.example.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : HomeRepository {
    override suspend fun getHome(): Flow<HomeResponse> {
        return flow {
            val response = remoteDataSource.getHome()
            if (response.isSuccessful) {
                val body = response.body()
                mapRemoteResponseToDomain(body)?.let { emit(it) }
                mapRemoteResponseToLocalStorage(body)?.let { localDataSource.saveHome(it) }
            } else {
                emit(mapLocalResponseToDomain(localDataSource.getHome()))
            }
        }
    }

    private fun mapRemoteResponseToDomain(homeDTO: HomeDTO?) =
        homeDTO?.mapToDomain()


    private fun mapRemoteResponseToLocalStorage(homeDTO: HomeDTO?) =
        homeDTO?.mapToEntity()


    private fun mapLocalResponseToDomain(homeEntity: HomeEntity) = homeEntity.mapToDomain()


}