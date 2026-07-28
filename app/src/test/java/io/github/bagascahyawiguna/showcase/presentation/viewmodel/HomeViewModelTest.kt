package io.github.bagascahyawiguna.showcase.presentation.viewmodel

import io.github.bagascahyawiguna.showcase.domain.model.TvShow
import io.github.bagascahyawiguna.showcase.domain.repository.TvShowRepository
import io.github.bagascahyawiguna.showcase.presentation.state.HomeUiState
import io.github.bagascahyawiguna.showcase.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val repository: TvShowRepository = mockk()

    @Test
    fun `loadShows emits HomeUiState Success when repository returns data`() = runTest {
        // Given
        val showsList = listOf(
            TvShow(
                id = 1,
                name = "Under the Dome",
                mediumImageUrl = "http://example.com/medium.jpg",
                originalImageUrl = "http://example.com/original.jpg",
                ratingAverage = 6.5,
                premiered = "2013-06-24",
                summary = "Summary text"
            )
        )
        coEvery { repository.getShows(0) } returns Result.success(showsList)

        // When
        val viewModel = HomeViewModel(repository)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is HomeUiState.Success)
        assertEquals(showsList, (state as HomeUiState.Success).shows)
        coVerify(exactly = 1) { repository.getShows(0) }
    }

    @Test
    fun `loadShows emits HomeUiState Success with empty list when repository returns empty list`() = runTest {
        // Given
        coEvery { repository.getShows(0) } returns Result.success(emptyList())

        // When
        val viewModel = HomeViewModel(repository)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is HomeUiState.Success)
        assertTrue((state as HomeUiState.Success).shows.isEmpty())
        coVerify(exactly = 1) { repository.getShows(0) }
    }

    @Test
    fun `loadShows emits HomeUiState Error when repository returns failure`() = runTest {
        // Given
        val errorMessage = "Failed to load TV shows"
        coEvery { repository.getShows(0) } returns Result.failure(Exception(errorMessage))

        // When
        val viewModel = HomeViewModel(repository)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is HomeUiState.Error)
        assertEquals(errorMessage, (state as HomeUiState.Error).message)
        coVerify(exactly = 1) { repository.getShows(0) }
    }

    @Test
    fun `retry reloads shows from repository`() = runTest {
        // Given
        coEvery { repository.getShows(0) } returns Result.failure(Exception("Error")) andThen Result.success(emptyList())
        val viewModel = HomeViewModel(repository)

        // Initial check - Error state
        assertTrue(viewModel.uiState.value is HomeUiState.Error)

        // When
        viewModel.retry()

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is HomeUiState.Success)
        coVerify(exactly = 2) { repository.getShows(0) }
    }
}
