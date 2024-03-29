package com.example.domain.model

data class MealResponse(
    val mealTitle: String? = null,
    val strYoutube: String? = null,
    val strInstructions: String? = null,
    val strArea: String? = null,
    val strCategory: String? = null,
    val strTags: ArrayList<String>? = null
)