package com.example.data.core

object NativeConfig {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getHomeBaseUrl(): String

    external fun getMealsBaseUrl(): String
}

