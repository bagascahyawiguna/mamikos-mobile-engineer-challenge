package io.github.bagascahyawiguna.showcase.data.repository

import io.github.bagascahyawiguna.showcase.data.remote.api.TvMazeApi
import io.github.bagascahyawiguna.showcase.data.remote.dto.ImageDto
import io.github.bagascahyawiguna.showcase.data.remote.dto.RatingDto
import io.github.bagascahyawiguna.showcase.data.remote.dto.TvShowDto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TvShowRepositoryImplTest {

    private val api: TvMazeApi = mockk(relaxed = true)
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: TvShowRepositoryImpl

    @Before
    fun setUp() {
        coEvery { api.getSeasons(any()) } returns emptyList()
        coEvery { api.getEpisodes(any()) } returns emptyList()
        coEvery { api.getCast(any()) } returns emptyList()

        repository = TvShowRepositoryImpl(
            api = api,
            ioDispatcher = testDispatcher
        )
    }

    @Test
    fun `getShows returns success with mapped domain models`() = runTest(testDispatcher) {
        // Given
        val dtoList = listOf(
            TvShowDto(
                id = 1,
                name = "Under the Dome",
                image = ImageDto(medium = "http://example.com/medium.jpg", original = "http://example.com/original.jpg"),
                rating = RatingDto(average = 6.5),
                premiered = "2013-06-24",
                summary = "<p>Summary text</p>"
            )
        )
        coEvery { api.getShows(0) } returns dtoList

        // When
        val result = repository.getShows(0)

        // Then
        assertTrue(result.isSuccess)
        val shows = result.getOrNull()
        assertEquals(1, shows?.size)
        val show = shows?.first()
        assertEquals(1, show?.id)
        assertEquals("Under the Dome", show?.name)
        assertEquals("http://example.com/medium.jpg", show?.mediumImageUrl)
        assertEquals("http://example.com/original.jpg", show?.originalImageUrl)
        assertEquals(6.5, show?.ratingAverage)
        assertEquals("2013-06-24", show?.premiered)
        assertEquals("<p>Summary text</p>", show?.summary)
        coVerify(exactly = 1) { api.getShows(0) }
    }

    @Test
    fun `getShows returns success with empty list when API returns empty list`() = runTest(testDispatcher) {
        // Given
        coEvery { api.getShows(0) } returns emptyList()

        // When
        val result = repository.getShows(0)

        // Then
        assertTrue(result.isSuccess)
        val shows = result.getOrNull()
        assertTrue(shows.isNullOrEmpty())
        coVerify(exactly = 1) { api.getShows(0) }
    }

    @Test
    fun `getShows returns failure when API throws exception`() = runTest(testDispatcher) {
        // Given
        val exception = IOException("Network Error")
        coEvery { api.getShows(0) } throws exception

        // When
        val result = repository.getShows(0)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
        coVerify(exactly = 1) { api.getShows(0) }
    }

    @Test
    fun `getShowDetail returns success with mapped domain model`() = runTest(testDispatcher) {
        // Given
        val dto = TvShowDto(
            id = 1,
            name = "Under the Dome",
            image = ImageDto(medium = "http://example.com/medium.jpg", original = "http://example.com/original.jpg"),
            rating = RatingDto(average = 6.5),
            premiered = "2013-06-24",
            summary = "<p>Summary text</p>"
        )
        coEvery { api.getShowDetail(1) } returns dto

        // When
        val result = repository.getShowDetail(1)

        // Then
        assertTrue(result.isSuccess)
        val show = result.getOrNull()
        assertEquals(1, show?.id)
        assertEquals("Under the Dome", show?.name)
        assertEquals(6.5, show?.ratingAverage)
        coVerify(exactly = 1) { api.getShowDetail(1) }
    }

    @Test
    fun `getShowDetail returns failure when API throws exception for invalid ID`() = runTest(testDispatcher) {
        // Given
        val exception = RuntimeException("404 Not Found")
        coEvery { api.getShowDetail(999) } throws exception

        // When
        val result = repository.getShowDetail(999)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
        coVerify(exactly = 1) { api.getShowDetail(999) }
    }
}
