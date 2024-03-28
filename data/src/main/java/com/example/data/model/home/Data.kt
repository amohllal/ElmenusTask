package com.example.data.model.home


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
internal data class Data(
    @SerializedName("DynamicCollectionViewModel")
    val dynamicCollectionViewModel: List<DynamicCollectionViewModel>? = listOf()
) : Parcelable