package com.example.domain.usecase

import com.example.domain.model.MealResponse
import com.example.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class GetMealDetailsUseCaseTest {

    private lateinit var mealDetailsRepository: MealDetailsRepository
    private lateinit var getMealDetailsUseCase: GetMealDetailsUseCase

    @Before
    fun setup() {
        mealDetailsRepository = mock(MealDetailsRepository::class.java)
        getMealDetailsUseCase = GetMealDetailsUseCase(mealDetailsRepository)
    }

    @Test
    fun `test getMealDetailsUseCase with valid data`() = runBlocking {
        val testData = MealResponse(
            mealTitle = "Test Meal",
            strYoutube = "https://www.youtube.com/test",
            strInstructions = "Test instructions",
            strArea = "Test area",
            strCategory = "Test category",
            strTags = arrayListOf("Tag1", "Tag2")
        )

        val mealId = "575544"
        `when`(mealDetailsRepository.getMealDetails(mealId)).thenReturn(flow {
            emit(testData)
        })

        val result = getMealDetailsUseCase(mealId).toList()

        assertEquals(1, result.size)
        assertEquals(testData, result.first())
    }

    @Test
    fun `test getMealDetailsUseCase with empty data`() = runBlocking {
        val mealId = "575544"
        `when`(mealDetailsRepository.getMealDetails(mealId)).thenReturn(flow {
        })

        val result = getMealDetailsUseCase(mealId).toList()

        assertEquals(0, result.size)
    }

    @Test
    fun `test getMealDetailsUseCase with RuntimeException`() = runBlocking {
        val testError = RuntimeException("Test error")

        val mealId = "575544"
        `when`(mealDetailsRepository.getMealDetails(mealId)).thenThrow(testError)

        val result = try {
            getMealDetailsUseCase(mealId).toList()
        } catch (e: Exception) {
            listOf(e)
        }

        assertEquals(1, result.size)
        assertEquals(testError, result.first())
    }
}