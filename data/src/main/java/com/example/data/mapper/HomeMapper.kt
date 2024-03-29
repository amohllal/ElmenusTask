package com.example.data.mapper

import com.example.data.core.splitTagsToList
import com.example.data.model.home.HomeDTO
import com.example.domain.model.Announcement
import com.example.domain.model.AnnouncementDetails
import com.example.domain.model.Banner
import com.example.domain.model.Category
import com.example.domain.model.CategoryDetails
import com.example.domain.model.HomeResponse
import com.example.domain.model.Ingredient
import com.example.domain.model.IngredientDetails
import com.example.domain.model.Product
import com.example.domain.model.ProductDetails

fun HomeDTO.mapToDomain() = this.data?.dynamicCollectionViewModel?.let {
    HomeResponse(
        banner = it[4].let { dynamicCollectionViewModel ->
            Banner(
                title = dynamicCollectionViewModel.title,
                id = dynamicCollectionViewModel.id.toString(),
                url = dynamicCollectionViewModel.url,
                type = dynamicCollectionViewModel.type
            )
        },
        topCategory = it[0].let { dynamicCollectionViewModel ->
            Category(
                title = dynamicCollectionViewModel.title,
                categoryList = dynamicCollectionViewModel.categories?.map { categroyX ->
                    CategoryDetails(
                        idCategory = categroyX.idCategory,
                        strCategory = categroyX.strCategory,
                        strCategoryThumb = categroyX.strCategoryThumb
                    )
                } as ArrayList<CategoryDetails>
            )
        },
        product = it[1].let { dynamicCollectionViewModel ->
            Product(
                title = dynamicCollectionViewModel.title,
                productList = dynamicCollectionViewModel.meals?.map { mealX ->
                    ProductDetails(
                        idMeal = mealX.idMeal,
                        strMeal = mealX.strMeal,
                        strCategory = mealX.strCategory,
                        strArea = mealX.strArea,
                        strMealThumb = mealX.strMealThumb,
                        strTags = mealX.strTags?.splitTagsToList()?.map { tag ->
                            tag
                        } as ArrayList<String>?
                    )
                } as ArrayList<ProductDetails>)
        },
        ingredient = it[2].let { dynamicCollectionViewModel ->
            Ingredient(
                title = dynamicCollectionViewModel.title,
                ingredientsList = dynamicCollectionViewModel.ingredients?.map { ingredient ->
                    IngredientDetails(
                        idIngredient = ingredient.idIngredient,
                        ingredientIcon = ingredient.strType?.toInt()
                    )
                } as ArrayList<IngredientDetails>)
        }, announcement = it[3].let { dynamicCollectionViewModel ->
            Announcement(
                title = dynamicCollectionViewModel.title,
                announcementList = dynamicCollectionViewModel.announcements?.map { announcement ->
                    AnnouncementDetails(id = announcement.id, strThumb = announcement.strThumb)
                } as ArrayList<AnnouncementDetails>)
        })

}