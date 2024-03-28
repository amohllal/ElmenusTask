package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
internal data class DynamicCollectionViewModel(
    @SerializedName("Announcements")
    val announcements: List<Announcement>? = listOf(),
    @SerializedName("Categories")
    val categories: List<CategoryX>? = listOf(),
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("Ingredients")
    val ingredients: List<Ingredient>? = listOf(),
    @SerializedName("Meals")
    val meals: List<MealX>? = listOf(),
    @SerializedName("Order")
    val order: Int? = 0,
    @SerializedName("Title")
    val title: String? = "",
    @SerializedName("Type")
    val type: String? = "",
    @SerializedName("Url")
    val url: String? = ""
) : Parcelable