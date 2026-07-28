package io.github.bagascahyawiguna.showcase.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvShowDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String? = null,
    @SerialName("image")
    val image: ImageDto? = null,
    @SerialName("rating")
    val rating: RatingDto? = null,
    @SerialName("premiered")
    val premiered: String? = null,
    @SerialName("summary")
    val summary: String? = null
)

@Serializable
data class ImageDto(
    @SerialName("medium")
    val medium: String? = null,
    @SerialName("original")
    val original: String? = null
)

@Serializable
data class RatingDto(
    @SerialName("average")
    val average: Double? = null
)
