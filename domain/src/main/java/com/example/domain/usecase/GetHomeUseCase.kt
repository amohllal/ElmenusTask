package com.example.domain.usecase

import com.example.domain.repository.HomeRepository
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke() = homeRepository.getHome()
}