package com.example.data.entity

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "home_entity")
data class HomeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @Embedded
    val banner: Banner? = null,
    @Embedded
    val topCategory: Category? = null,
    @Embedded
    val product: Product? = null,
    @Embedded
    val ingredient: Ingredient? = null,
    @Embedded
    val announcement: Announcement? = null
)
@Keep
data class Banner(
    @ColumnInfo(name = "bannerTitle")
    val title: String? = null,
    @ColumnInfo(name = "bannerId")
    val id: String? = null,
    val url: String? = null,
    val type: String? = null
)
@Keep
data class Category(
    @ColumnInfo(name = "categoryTitle")
    val title: String? = null,
    val categoryList: ArrayList<CategoryDetails>? = null,
)
@Keep
data class CategoryDetails(
    val idCategory: String? =null,
    val strCategory: String? = null,
    val strCategoryThumb: String? = null,
)
@Keep
data class Product(
    @ColumnInfo(name = "productTitle")
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
    @ColumnInfo(name = "announcementTitle")
    val title: String? = null,
    val announcementList: ArrayList<AnnouncementDetails>? = null,
)
@Keep
data class AnnouncementDetails(
    @ColumnInfo(name = "announcementId")
    val id: Int? = 0,
    val strThumb: String? = null
)
@Keep
data class Ingredient(
    @ColumnInfo(name = "ingredientTitle")
    val title: String? = null,
    val ingredientsList: ArrayList<IngredientDetails>? = null,
)
@Keep
data class IngredientDetails(
    val idIngredient: String? = null,
    val ingredientIcon: Int? = 0
)