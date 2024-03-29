package com.example.data.source

import com.example.data.entity.HomeEntity
import com.example.data.entity.MealEntity
import com.example.data.entity.TopCategoryEntity
import com.example.data.local.ElmenusDAO
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val elmenusDAO: ElmenusDAO
) {
    fun saveHome(homeEntity: HomeEntity){
        elmenusDAO.saveHome(homeEntity)
    }

    fun getHome() = elmenusDAO.getHomeFromDatabase()


    fun saveTopCategory(topCategoryEntity: TopCategoryEntity){
        elmenusDAO.saveTopCategory(topCategoryEntity)
    }

    fun getTopCategory() = elmenusDAO.getTopCategoryFromDatabase()


    fun saveMeal(mealEntity: MealEntity){
        elmenusDAO.saveMeal(mealEntity)
    }

    fun getMeal() = elmenusDAO.getMealFromDatabase()
}