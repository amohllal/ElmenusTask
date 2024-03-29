package com.example.data.model.meal


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class MealsDetailsDTO(
    @SerializedName("meals")
    val meals: ArrayList<Meal?>? = null
) : Parcelable