package com.example.domain.usecase

import com.example.domain.repository.TopCategoryRepository
import javax.inject.Inject

class GetTopCategoryUseCase @Inject constructor(private val topCategoryRepository: TopCategoryRepository) {

    suspend operator fun invoke(category: String) = topCategoryRepository.getTopCategory(category)
}