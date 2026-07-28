package io.github.bagascahyawiguna.showcase.data.mapper

import io.github.bagascahyawiguna.showcase.data.remote.dto.CastDto
import io.github.bagascahyawiguna.showcase.data.remote.dto.TvShowDto
import io.github.bagascahyawiguna.showcase.domain.model.CastMember
import io.github.bagascahyawiguna.showcase.domain.model.TvShow

fun TvShowDto.toDomainModel(
    totalSeasons: Int? = null,
    totalEpisodes: Int? = null,
    cast: List<CastMember> = emptyList()
): TvShow {
    return TvShow(
        id = id,
        name = name,
        url = url,
        mediumImageUrl = image?.medium,
        originalImageUrl = image?.original,
        ratingAverage = rating?.average,
        premiered = premiered,
        summary = summary,
        totalSeasons = totalSeasons,
        totalEpisodes = totalEpisodes,
        cast = cast
    )
}

fun CastDto.toDomainModel(): CastMember? {
    val personObj = person ?: return null
    return CastMember(
        id = personObj.id,
        name = personObj.name,
        characterName = character?.name,
        imageUrl = personObj.image?.medium ?: character?.image?.medium
    )
}

fun List<TvShowDto>.toDomainModelList(): List<TvShow> {
    return map { it.toDomainModel() }
}
