package com.example.elmenustask.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.HomeResponse
import com.example.domain.usecase.GetHomeUseCase
import com.example.elmenustask.core.wrapper.StateLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase,
) : ViewModel() {

    val homeLiveData by lazy { StateLiveData<HomeResponse>() }


    fun getHome() {
        viewModelScope.launch {
            getHomeUseCase()
                .flowOn(Dispatchers.Main)
                .onStart { homeLiveData.postLoading() }
                .collect {
                    homeLiveData.postSuccess(it)
                }
        }
    }
}