package com.example.domain.model

import androidx.annotation.Keep

@Keep
data class TopCategoryResponse(
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
