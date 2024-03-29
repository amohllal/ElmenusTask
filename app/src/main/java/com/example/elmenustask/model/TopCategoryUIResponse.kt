package com.example.elmenustask.model

data class TopCategoryUIResponse(
    val imageUrl: String? = null,
    val title: String? = null,
    val mealList: ArrayList<Meals>? = null
)

data class Meals(
    val imageUrl: String? = null,
    val title: String? = null,
    val id: String? = null
)
