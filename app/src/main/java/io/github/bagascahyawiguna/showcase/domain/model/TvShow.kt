package io.github.bagascahyawiguna.showcase.domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val url: String? = null,
    val mediumImageUrl: String?,
    val originalImageUrl: String?,
    val ratingAverage: Double?,
    val premiered: String?,
    val summary: String?
)
