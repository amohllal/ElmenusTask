package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.entity.HomeEntity
import com.example.data.entity.MealEntity
import com.example.data.entity.TopCategoryEntity

@Dao
interface ElmenusDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHome(homeEntity: HomeEntity)


    @Query("SELECT * FROM home_entity")
    fun getHomeFromDatabase(): HomeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopCategory(topCategoryEntity: TopCategoryEntity)


    @Query("SELECT * FROM top_category_entity")
    fun getTopCategoryFromDatabase(): TopCategoryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMeal(mealEntity: MealEntity)


    @Query("SELECT * FROM meal_entity")
    fun getMealFromDatabase(): MealEntity
}