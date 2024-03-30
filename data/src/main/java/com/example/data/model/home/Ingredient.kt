package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep

@Parcelize
@Keep
data class Ingredient(
    @SerializedName("idIngredient")
    val idIngredient: String? = null,
    @SerializedName("strDescription")
    val strDescription: String? = null,
    @SerializedName("strIngredient")
    val strIngredient: String? = null,
    @SerializedName("strType")
    val strType: String? = null
) : Parcelable