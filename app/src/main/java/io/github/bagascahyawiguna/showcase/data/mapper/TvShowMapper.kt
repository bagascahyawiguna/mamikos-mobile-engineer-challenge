package io.github.bagascahyawiguna.showcase.data.mapper

import io.github.bagascahyawiguna.showcase.data.remote.dto.TvShowDto
import io.github.bagascahyawiguna.showcase.domain.model.TvShow

fun TvShowDto.toDomainModel(): TvShow {
    return TvShow(
        id = id,
        name = name,
        url = url,
        mediumImageUrl = image?.medium,
        originalImageUrl = image?.original,
        ratingAverage = rating?.average,
        premiered = premiered,
        summary = summary
    )
}

fun List<TvShowDto>.toDomainModelList(): List<TvShow> {
    return map { it.toDomainModel() }
}
