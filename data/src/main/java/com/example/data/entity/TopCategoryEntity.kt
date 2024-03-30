package com.example.data.entity

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity(tableName = "top_category_entity")
data class TopCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imageUrl: String? = null,
    val title: String? = null,
    val mealList: ArrayList<Meals>? = null
)
@Keep
data class Meals(
    @ColumnInfo(name = "mealImage")
    val imageUrl: String? = null,
    @ColumnInfo(name = "mealTitle")
    val title: String? = null,
    @ColumnInfo(name = "mealId")
    val id: String? = null
)
