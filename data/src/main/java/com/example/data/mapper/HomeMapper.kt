package com.example.data.mapper

import com.example.data.core.splitTagsToList
import com.example.data.entity.HomeEntity
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

fun HomeDTO.mapToEntity() = this.data?.dynamicCollectionViewModel?.let {
    HomeEntity(
        banner = it[4].let { dynamicCollectionViewModel ->
            com.example.data.entity.Banner(
                title = dynamicCollectionViewModel.title,
                id = dynamicCollectionViewModel.id.toString(),
                url = dynamicCollectionViewModel.url,
                type = dynamicCollectionViewModel.type
            )
        },
        topCategory = it[0].let { dynamicCollectionViewModel ->
            com.example.data.entity.Category(
                title = dynamicCollectionViewModel.title,
                categoryList = dynamicCollectionViewModel.categories?.map { categroyX ->
                    com.example.data.entity.CategoryDetails(
                        idCategory = categroyX.idCategory,
                        strCategory = categroyX.strCategory,
                        strCategoryThumb = categroyX.strCategoryThumb
                    )
                } as ArrayList<com.example.data.entity.CategoryDetails>
            )
        },
        product = it[1].let { dynamicCollectionViewModel ->
            com.example.data.entity.Product(
                title = dynamicCollectionViewModel.title,
                productList = dynamicCollectionViewModel.meals?.map { mealX ->
                    com.example.data.entity.ProductDetails(
                        idMeal = mealX.idMeal,
                        strMeal = mealX.strMeal,
                        strCategory = mealX.strCategory,
                        strArea = mealX.strArea,
                        strMealThumb = mealX.strMealThumb,
                        strTags = mealX.strTags?.splitTagsToList()?.map { tag ->
                            tag
                        } as ArrayList<String>?
                    )
                } as ArrayList<com.example.data.entity.ProductDetails>)
        },
        ingredient = it[2].let { dynamicCollectionViewModel ->
            com.example.data.entity.Ingredient(
                title = dynamicCollectionViewModel.title,
                ingredientsList = dynamicCollectionViewModel.ingredients?.map { ingredient ->
                    com.example.data.entity.IngredientDetails(
                        idIngredient = ingredient.idIngredient,
                        ingredientIcon = ingredient.strType?.toInt()
                    )
                } as ArrayList<com.example.data.entity.IngredientDetails>)
        }, announcement = it[3].let { dynamicCollectionViewModel ->
            com.example.data.entity.Announcement(
                title = dynamicCollectionViewModel.title,
                announcementList = dynamicCollectionViewModel.announcements?.map { announcement ->
                    com.example.data.entity.AnnouncementDetails(
                        id = announcement.id,
                        strThumb = announcement.strThumb
                    )
                } as ArrayList<com.example.data.entity.AnnouncementDetails>)
        })

}

fun HomeEntity?.mapToDomain() = HomeResponse(

    banner = this?.banner?.let {
        Banner(title = it.title, id = it.id, url = it.url, type = it.type)
    },
    product = this?.product?.let {
        Product(title = it.title, productList = it.productList?.map { productDetails ->
            ProductDetails(
                idMeal = productDetails.idMeal,
                strMeal = productDetails.strMeal,
                strCategory = productDetails.strCategory,
                strArea = productDetails.strArea,
                strMealThumb = productDetails.strMealThumb,
                strTags = productDetails.strTags?.map { tag ->
                    tag
                } as ArrayList<String>?
            )
        } as ArrayList<ProductDetails>)
    }, topCategory = this?.topCategory?.let {
        Category(title = it.title, categoryList = it.categoryList?.map { categoryDetails ->
            CategoryDetails(
                idCategory = categoryDetails.idCategory,
                strCategory = categoryDetails.strCategory,
                strCategoryThumb = categoryDetails.strCategoryThumb
            )
        } as ArrayList<CategoryDetails>?)
    }, ingredient = this?.ingredient?.let {
        Ingredient(
            title = it.title,
            ingredientsList = it.ingredientsList?.map { ingredientDetails ->
                IngredientDetails(
                    idIngredient = ingredientDetails.idIngredient,
                    ingredientIcon = ingredientDetails.ingredientIcon
                )
            } as ArrayList<IngredientDetails>?)
    }, announcement = this?.announcement?.let {
        Announcement(
            title = it.title,
            announcementList = it.announcementList?.map { announcementDetails ->
                AnnouncementDetails(
                    id = announcementDetails.id, strThumb = announcementDetails.strThumb
                )
            } as ArrayList<AnnouncementDetails>?)
    }
)