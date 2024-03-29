package com.example.data.mapper

import com.example.data.model.topcategory.TopCategoryDTO
import com.example.domain.model.Meals
import com.example.domain.model.TopCategoryResponse

fun TopCategoryDTO.mapToDomain() = TopCategoryResponse(

    mealList = this.meals?.map {
        Meals(imageUrl = it.strMealThumb, title = it.strMeal, id = it.idMeal)
    } as ArrayList<Meals>
)