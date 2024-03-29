package com.example.data.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromCategoryList(value: ArrayList<CategoryDetails>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toCategoryList(value: String?): ArrayList<CategoryDetails>? {
        val listType = object : TypeToken<ArrayList<CategoryDetails>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromProductList(value: ArrayList<ProductDetails>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toProductList(value: String?): ArrayList<ProductDetails>? {
        val listType = object : TypeToken<ArrayList<ProductDetails>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromIngredientList(value: ArrayList<IngredientDetails>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toIngredientList(value: String?): ArrayList<IngredientDetails>? {
        val listType = object : TypeToken<ArrayList<IngredientDetails>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromAnnouncementList(value: ArrayList<AnnouncementDetails>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toAnnouncementList(value: String?): ArrayList<AnnouncementDetails>? {
        val listType = object : TypeToken<ArrayList<AnnouncementDetails>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromMealList(value: ArrayList<Meals>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toMealsList(value: String?): ArrayList<Meals>? {
        val listType = object : TypeToken<ArrayList<Meals>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringArrayList(value: ArrayList<String>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toStringArrayList(value: String?): ArrayList<String>? {
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}