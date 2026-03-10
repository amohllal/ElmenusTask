package com.example.elmenustask.meals.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.MealResponse
import com.example.domain.usecase.GetMealDetailsUseCase
import com.example.elmenustask.core.wrapper.StateLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealDetailsUseCase: GetMealDetailsUseCase,
) : ViewModel() {

    var categoryId: String? = null
    val mealDetailLiveData by lazy { StateLiveData<MealResponse>() }


    fun getMealDetails(){
        viewModelScope.launch {
            getMealDetailsUseCase(categoryId ?: "")
                .flowOn(Dispatchers.IO)
                .onStart { mealDetailLiveData.postLoading(true) }
                .collect {
                    mealDetailLiveData.postSuccess(it)
                    mealDetailLiveData.postLoading(false)
                }
        }
    }
}