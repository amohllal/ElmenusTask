package com.example.domain.model

import androidx.annotation.Keep

@Keep
data class HomeResponse(
    val banner: Banner? = null,
    val topCategory: Category? = null,
    val product: Product? = null,
    val ingredient: Ingredient? = null,
    val announcement: Announcement? = null
)
@Keep
data class Banner(
    val title: String? = null,
    val id: String? = null,
    val url: String? = null,
    val type: String? = null
)
@Keep
data class Category(
    val title: String? = null,
    val categoryList: ArrayList<CategoryDetails>? = null,
)
@Keep
data class CategoryDetails(
    val idCategory: String? = null,
    val strCategory: String? = null,
    val strCategoryThumb: String? = null
)
@Keep
data class Product(
    val title: String? = null,
    val productList: ArrayList<ProductDetails>? = null,
)
@Keep
data class ProductDetails(
    val idMeal: String? = null,
    val strMeal: String? = null,
    val strCategory: String? = null,
    val strArea: String? = null,
    val strMealThumb: String? = null,
    val strTags: ArrayList<String>? = null,
)
@Keep
data class Announcement(
    val title: String? = null,
    val announcementList: ArrayList<AnnouncementDetails>? = null,
)
@Keep
data class AnnouncementDetails(
    val id: Int? = 0,
    val strThumb: String? = null
)
@Keep
data class Ingredient(
    val title: String? = null,
    val ingredientsList: ArrayList<IngredientDetails>? = null,
)
@Keep
data class IngredientDetails(val idIngredient: String? = null, val ingredientIcon: Int? = 0,val strIngredient: String?= null)