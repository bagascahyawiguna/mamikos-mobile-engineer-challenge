package io.github.bagascahyawiguna.showcase.data.repository

import io.github.bagascahyawiguna.showcase.data.mapper.toDomainModel
import io.github.bagascahyawiguna.showcase.data.mapper.toDomainModelList
import io.github.bagascahyawiguna.showcase.data.remote.api.TvMazeApi
import io.github.bagascahyawiguna.showcase.domain.model.TvShow
import io.github.bagascahyawiguna.showcase.domain.repository.TvShowRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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
                val dto = api.getShowDetail(id)
                Result.success(dto.toDomainModel())
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
