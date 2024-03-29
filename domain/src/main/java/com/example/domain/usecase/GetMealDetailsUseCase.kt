package com.example.domain.usecase

import com.example.domain.repository.MealDetailsRepository
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(private val mealDetailsRepository: MealDetailsRepository) {

    suspend operator fun invoke(mealId: String) = mealDetailsRepository.getMealDetails(mealId)
}