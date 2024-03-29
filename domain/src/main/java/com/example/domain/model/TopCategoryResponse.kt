package com.example.domain.model

data class TopCategoryResponse(
    val imageUrl: String? = null,
    val title: String? = null,
    val mealList: ArrayList<Meals>? = null
)

data class Meals(
    val imageUrl: String? = null,
    val title: String? = null,
    val id: String? = null
)
