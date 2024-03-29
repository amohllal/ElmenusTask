package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_entity")
data class MealEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val mealTitle: String? = null,
    val strYoutube: String? = null,
    val strInstructions: String? = null,
    val strArea: String? = null,
    val strCategory: String? = null,
    val strTags: ArrayList<String>? = null
)