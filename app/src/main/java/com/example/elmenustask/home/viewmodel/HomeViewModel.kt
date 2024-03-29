package com.example.elmenustask.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase,
) : ViewModel() {

}