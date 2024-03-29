package com.example.domain.model


data class HomeResponse(
    val banner: Banner? = null,
    val topCategory: Category? = null,
    val product: Product? = null,
    val ingredient: Ingredient? = null,
    val announcement: Announcement? = null
)

data class Banner(
    val title: String? = null,
    val id: String? = null,
    val url: String? = null,
    val type: String? = null
)

data class Category(
    val title: String? = null,
    val categoryList: ArrayList<CategoryDetails>? = null,
)

data class CategoryDetails(
    val idCategory: String? = null,
    val strCategory: String? = null,
    val strCategoryThumb: String? = null
)

data class Product(
    val title: String? = null,
    val productList: ArrayList<ProductDetails>? = null,
)

data class ProductDetails(
    val idMeal: String? = null,
    val strMeal: String? = null,
    val strCategory: String? = null,
    val strArea: String? = null,
    val strMealThumb: String? = null,
    val strTags: ArrayList<String>? = null,
)

data class Announcement(
    val title: String? = null,
    val announcementList: ArrayList<AnnouncementDetails>? = null,
)

data class AnnouncementDetails(
    val id: Int? = 0,
    val strThumb: String? = null
)

data class Ingredient(
    val title: String? = null,
    val ingredientsList: ArrayList<IngredientDetails>? = null,
)

data class IngredientDetails(val idIngredient: String? = null, val ingredientIcon: Int? = 0)