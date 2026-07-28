package io.github.bagascahyawiguna.showcase.data.remote.api

import io.github.bagascahyawiguna.showcase.data.remote.dto.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvMazeApi {

    @GET("shows")
    suspend fun getShows(
        @Query("page") page: Int = 0
    ): List<TvShowDto>

    @GET("shows/{id}")
    suspend fun getShowDetail(
        @Path("id") id: Int
    ): TvShowDto
}
