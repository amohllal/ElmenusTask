package com.example.elmenustask.top_category.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetTopCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopCategoryViewModel @Inject constructor(
    private val getTopCategoryUseCase: GetTopCategoryUseCase,
) : ViewModel() {
}