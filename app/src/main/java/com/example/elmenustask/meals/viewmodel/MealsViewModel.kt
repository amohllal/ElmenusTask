package com.example.elmenustask.meals.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetMealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealDetailsUseCase: GetMealDetailsUseCase,
) : ViewModel() {
}