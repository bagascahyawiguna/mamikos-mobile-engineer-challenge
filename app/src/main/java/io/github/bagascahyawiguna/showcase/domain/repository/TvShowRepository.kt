package io.github.bagascahyawiguna.showcase.domain.repository

import io.github.bagascahyawiguna.showcase.domain.model.TvShow

interface TvShowRepository {
    suspend fun getShows(page: Int = 0): Result<List<TvShow>>
    suspend fun getShowDetail(id: Int): Result<TvShow>
}
