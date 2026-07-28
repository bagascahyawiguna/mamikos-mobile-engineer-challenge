package io.github.bagascahyawiguna.showcase.presentation.viewmodel

import io.github.bagascahyawiguna.showcase.domain.model.TvShow
import io.github.bagascahyawiguna.showcase.domain.repository.TvShowRepository
import io.github.bagascahyawiguna.showcase.presentation.state.DetailUiState
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
class DetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val repository: TvShowRepository = mockk()

    @Test
    fun `loadShowDetail emits DetailUiState Success when repository returns data`() = runTest {
        // Given
        val show = TvShow(
            id = 1,
            name = "Under the Dome",
            mediumImageUrl = "http://example.com/medium.jpg",
            originalImageUrl = "http://example.com/original.jpg",
            ratingAverage = 6.5,
            premiered = "2013-06-24",
            summary = "Summary text"
        )
        coEvery { repository.getShowDetail(1) } returns Result.success(show)

        // When
        val viewModel = DetailViewModel(repository)
        viewModel.loadShowDetail(1)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is DetailUiState.Success)
        assertEquals(show, (state as DetailUiState.Success).show)
        coVerify(exactly = 1) { repository.getShowDetail(1) }
    }

    @Test
    fun `loadShowDetail emits DetailUiState Error when repository returns failure`() = runTest {
        // Given
        val errorMessage = "Failed to load show detail"
        coEvery { repository.getShowDetail(1) } returns Result.failure(Exception(errorMessage))

        // When
        val viewModel = DetailViewModel(repository)
        viewModel.loadShowDetail(1)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is DetailUiState.Error)
        assertEquals(errorMessage, (state as DetailUiState.Error).message)
        coVerify(exactly = 1) { repository.getShowDetail(1) }
    }

    @Test
    fun `retry reloads show detail from repository`() = runTest {
        // Given
        val show = TvShow(
            id = 1,
            name = "Under the Dome",
            mediumImageUrl = "http://example.com/medium.jpg",
            originalImageUrl = "http://example.com/original.jpg",
            ratingAverage = 6.5,
            premiered = "2013-06-24",
            summary = "Summary text"
        )
        coEvery { repository.getShowDetail(1) } returns Result.failure(Exception("Error")) andThen Result.success(show)

        val viewModel = DetailViewModel(repository)
        viewModel.loadShowDetail(1)

        // Initial check - Error state
        assertTrue(viewModel.uiState.value is DetailUiState.Error)

        // When
        viewModel.retry()

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is DetailUiState.Success)
        assertEquals(show, (state as DetailUiState.Success).show)
        coVerify(exactly = 2) { repository.getShowDetail(1) }
    }
}
