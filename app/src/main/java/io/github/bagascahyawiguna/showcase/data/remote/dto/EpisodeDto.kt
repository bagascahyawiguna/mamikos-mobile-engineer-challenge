package io.github.bagascahyawiguna.showcase.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String? = null
)
