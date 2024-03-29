package com.example.domain.usecase

import com.example.domain.model.Meals
import com.example.domain.model.TopCategoryResponse
import com.example.domain.repository.TopCategoryRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class GetTopCategoryUseCaseTest {

    private lateinit var topCategoryRepository: TopCategoryRepository
    private lateinit var getTopCategoryUseCase: GetTopCategoryUseCase

    @Before
    fun setup() {
        topCategoryRepository = mock(TopCategoryRepository::class.java)
        getTopCategoryUseCase = GetTopCategoryUseCase(topCategoryRepository)
    }

    @Test
    fun `test getTopCategoryUseCase with valid data`() = runBlocking {
        val testData = TopCategoryResponse(
            imageUrl = "Test Image URL",
            title = "Teriyaki Chicken Casserole",
            mealList = arrayListOf(
                Meals(imageUrl = "Meal Image URL", title = "Teriyaki Chicken Casserole", id = "345435")
            )
        )

        val category = "Chicken"
        `when`(topCategoryRepository.getTopCategory(category)).thenReturn(flow {
            emit(testData)
        })

        val result = getTopCategoryUseCase(category).toList()

        assertEquals(1, result.size)
        assertEquals(testData, result.first())
    }

    @Test
    fun `test getTopCategoryUseCase with empty data`() = runBlocking {
        val category = "Chicken"
        `when`(topCategoryRepository.getTopCategory(category)).thenReturn(flow {
        })

        val result = getTopCategoryUseCase(category).toList()

        assertEquals(0, result.size)
    }

    @Test
    fun `test getTopCategoryUseCase with RuntimeException`() = runBlocking {
        val testError = RuntimeException("Test error")

        val category = "Chicken"
        `when`(topCategoryRepository.getTopCategory(category)).thenThrow(testError)

        val result = try {
            getTopCategoryUseCase(category).toList()
        } catch (e: Exception) {
            listOf(e)
        }

        assertEquals(1, result.size)
        assertEquals(testError, result.first())
    }
}