package com.example.elmenustask.top_category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.TopCategoryResponse
import com.example.domain.usecase.GetTopCategoryUseCase
import com.example.elmenustask.core.wrapper.StateLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopCategoryViewModel @Inject constructor(
    private val getTopCategoryUseCase: GetTopCategoryUseCase,
) : ViewModel() {

    val topCategoryLiveData by lazy { StateLiveData<TopCategoryResponse>() }
    var categoryName: String? = null

    fun getTopCategory() {
        viewModelScope.launch {
            getTopCategoryUseCase(categoryName ?: "")
                .flowOn(Dispatchers.Main)
                .onStart { topCategoryLiveData.postLoading() }
                .collect {
                    topCategoryLiveData.postSuccess(it)
                }
        }
    }

}