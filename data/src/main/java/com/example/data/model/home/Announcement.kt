package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep

@Keep
@Parcelize
data class Announcement(
    @SerializedName("Category")
    val category: CategoryX? = CategoryX(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("Meal")
    val meal: Meal? = Meal(),
    @SerializedName("strThumb")
    val strThumb: String? = ""
) : Parcelable