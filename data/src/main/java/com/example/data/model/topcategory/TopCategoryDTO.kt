package com.example.data.model.topcategory


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class TopCategoryDTO(
    @SerializedName("meals")
    val meals: ArrayList<Meal>? = null
) : Parcelable
@Parcelize
data class Meal(
    @SerializedName("idMeal")
    val idMeal: String? = null,
    @SerializedName("strMeal")
    val strMeal: String? = null,
    @SerializedName("strMealThumb")
    val strMealThumb: String? = null
) : Parcelable