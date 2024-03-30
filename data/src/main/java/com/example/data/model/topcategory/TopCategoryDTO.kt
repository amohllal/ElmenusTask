package com.example.data.model.topcategory


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep

@Parcelize
@Keep
data class TopCategoryDTO(
    @SerializedName("meals")
    val meals: ArrayList<Meal>? = null
) : Parcelable
@Parcelize
@Keep
data class Meal(
    @SerializedName("idMeal")
    val idMeal: String? = null,
    @SerializedName("strMeal")
    val strMeal: String? = null,
    @SerializedName("strMealThumb")
    val strMealThumb: String? = null
) : Parcelable