package io.github.bagascahyawiguna.showcase.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeasonDto(
    @SerialName("id")
    val id: Int,
    @SerialName("number")
    val number: Int? = null
)
