package com.example.domain.usecase

import com.example.domain.model.Announcement
import com.example.domain.model.Banner
import com.example.domain.model.Category
import com.example.domain.model.HomeResponse
import com.example.domain.model.Ingredient
import com.example.domain.model.Product
import com.example.domain.repository.HomeRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class GetHomeUseCaseTest {

    private lateinit var homeRepository: HomeRepository
    private lateinit var getHomeUseCase: GetHomeUseCase

    @Before
    fun setup() {
        homeRepository = mock(HomeRepository::class.java)
        getHomeUseCase = GetHomeUseCase(homeRepository)
    }

    @Test
    fun `test getHomeUseCase with valid data`() = runBlocking {
        val testData = HomeResponse(
            banner = Banner(title = "Test Banner"),
            topCategory = Category(title = "Test Category"),
            product = Product(title = "Test Product"),
            ingredient = Ingredient(title = "Test Ingredient"),
            announcement = Announcement(title = "Test Announcement")
        )

        `when`(homeRepository.getHome()).thenReturn(flow {
            emit(testData)
        })

        val result = getHomeUseCase().toList()

        assertEquals(1, result.size)
        assertEquals(testData, result.first())
    }

    @Test
    fun `test getHomeUseCase with empty data`() = runBlocking {
        `when`(homeRepository.getHome()).thenReturn(flow {})

        val result = getHomeUseCase().toList()

        assertEquals(0, result.size)
    }

    @Test
    fun `test getHomeUseCase with RuntimeException`() = runBlocking {
        val testError = RuntimeException("Test error")

        `when`(homeRepository.getHome()).thenThrow(testError)

        val result = try {
            getHomeUseCase().toList()
        } catch (e: Exception) {
            listOf(e)
        }

        assertEquals(1, result.size)
        assertEquals(testError, result.first())
    }
}