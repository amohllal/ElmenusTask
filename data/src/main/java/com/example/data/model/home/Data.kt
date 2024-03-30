package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep

@Parcelize
@Keep
data class Data(
    @SerializedName("DynamicCollectionViewModel")
    val dynamicCollectionViewModel: List<DynamicCollectionViewModel>? = listOf()
) : Parcelable