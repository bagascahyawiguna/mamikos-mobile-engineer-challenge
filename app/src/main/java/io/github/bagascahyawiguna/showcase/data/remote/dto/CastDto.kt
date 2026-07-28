package io.github.bagascahyawiguna.showcase.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CastDto(
    @SerialName("person")
    val person: PersonDto? = null,
    @SerialName("character")
    val character: CharacterDto? = null
)

@Serializable
data class PersonDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("image")
    val image: ImageDto? = null
)

@Serializable
data class CharacterDto(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("image")
    val image: ImageDto? = null
)
