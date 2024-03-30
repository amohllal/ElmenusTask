package com.example.elmenustask.model

import androidx.annotation.Keep

@Keep
data class TopCategoryUIResponse(
    val imageUrl: String? = null,
    val title: String? = null,
    val mealList: ArrayList<Meals>? = null
)
@Keep
data class Meals(
    val imageUrl: String? = null,
    val title: String? = null,
    val id: String? = null
)
