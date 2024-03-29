package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class CategoryX(
    @SerializedName("idCategory")
    val idCategory: String? = null,
    @SerializedName("strCategory")
    val strCategory: String? = null,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String? = null
) : Parcelable