package com.example.data.mapper

import com.example.data.core.splitTagsToList
import com.example.data.model.meal.MealsDetailsDTO
import com.example.domain.model.MealResponse

fun MealsDetailsDTO.mapToDomain() = this.meals?.get(0)?.let { meal ->
    MealResponse(
        mealTitle = meal.strMeal,
        strYoutube = meal.strYoutube,
        strInstructions = meal.strInstructions,
        strArea = meal.strArea,
        strCategory = meal.strCategory,
        strTags = meal.strTags.splitTagsToList()?.map { tag ->
            tag
        } as ArrayList<String>?
    )
}