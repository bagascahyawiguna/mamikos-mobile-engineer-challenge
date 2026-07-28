package io.github.bagascahyawiguna.showcase.data.repository

import io.github.bagascahyawiguna.showcase.data.mapper.toDomainModel
import io.github.bagascahyawiguna.showcase.data.mapper.toDomainModelList
import io.github.bagascahyawiguna.showcase.data.remote.api.TvMazeApi
import io.github.bagascahyawiguna.showcase.domain.model.TvShow
import io.github.bagascahyawiguna.showcase.domain.repository.TvShowRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class TvShowRepositoryImpl(
    private val api: TvMazeApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TvShowRepository {

    override suspend fun getShows(page: Int): Result<List<TvShow>> {
        return withContext(ioDispatcher) {
            try {
                val dtoList = api.getShows(page)
                Result.success(dtoList.toDomainModelList())
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun getShowDetail(id: Int): Result<TvShow> {
        return withContext(ioDispatcher) {
            try {
                val showDto = api.getShowDetail(id)
                coroutineScope {
                    val seasonsDeferred = async { runCatching { api.getSeasons(id) }.getOrDefault(emptyList()) }
                    val episodesDeferred = async { runCatching { api.getEpisodes(id) }.getOrDefault(emptyList()) }
                    val castDeferred = async { runCatching { api.getCast(id) }.getOrDefault(emptyList()) }

                    val seasonsDto = seasonsDeferred.await()
                    val episodesDto = episodesDeferred.await()
                    val castDto = castDeferred.await()

                    val totalSeasons = seasonsDto.size.takeIf { it > 0 }
                    val totalEpisodes = episodesDto.size.takeIf { it > 0 }
                    val topCast = castDto.mapNotNull { it.toDomainModel() }.take(5)

                    Result.success(
                        showDto.toDomainModel(
                            totalSeasons = totalSeasons,
                            totalEpisodes = totalEpisodes,
                            cast = topCast
                        )
                    )
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
