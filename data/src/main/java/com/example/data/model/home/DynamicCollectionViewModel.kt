package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class DynamicCollectionViewModel(
    @SerializedName("Announcements")
    val announcements: ArrayList<Announcement>? = null,
    @SerializedName("Categories")
    val categories: ArrayList<CategoryX>? = null,
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("Ingredients")
    val ingredients: ArrayList<Ingredient>? = null,
    @SerializedName("Meals")
    val meals: ArrayList<MealX>? = null,
    @SerializedName("Order")
    val order: Int? = 0,
    @SerializedName("Title")
    val title: String? = "",
    @SerializedName("Type")
    val type: String? = "",
    @SerializedName("Url")
    val url: String? = ""
) : Parcelable