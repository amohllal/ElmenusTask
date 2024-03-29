package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.entity.Converters
import com.example.data.entity.HomeEntity
import com.example.data.entity.MealEntity
import com.example.data.entity.TopCategoryEntity

@Database(entities = [HomeEntity::class,TopCategoryEntity::class,MealEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ElmenusDataBase : RoomDatabase() {
    abstract fun getElmenusDao(): ElmenusDAO

}