package com.example.data.mapper

import com.example.data.entity.TopCategoryEntity
import com.example.data.model.topcategory.TopCategoryDTO
import com.example.domain.model.Meals
import com.example.domain.model.TopCategoryResponse

fun TopCategoryDTO.mapToDomain() = TopCategoryResponse(

    mealList = this.meals?.map {
        Meals(imageUrl = it.strMealThumb, title = it.strMeal, id = it.idMeal)
    } as ArrayList<Meals>?
)

fun TopCategoryEntity?.mapToDomain() =
    TopCategoryResponse(
        imageUrl = this?.imageUrl,
        title = this?.title,
        mealList = this?.mealList?.map {
            Meals(imageUrl = it.imageUrl, title = it.title, id = it.id)
        } as ArrayList<Meals>?)

fun TopCategoryDTO.mapToEntity() = TopCategoryEntity(
    mealList = this.meals?.map {
        com.example.data.entity.Meals(
            imageUrl = it.strMealThumb,
            title = it.strMeal,
            id = it.idMeal
        )
    } as ArrayList<com.example.data.entity.Meals>?)