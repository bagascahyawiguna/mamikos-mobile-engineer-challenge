package io.github.bagascahyawiguna.showcase.presentation.state

import io.github.bagascahyawiguna.showcase.domain.model.TvShow

sealed interface DetailUiState {
    object Loading : DetailUiState
    data class Success(val show: TvShow) : DetailUiState
    data class Error(val message: String) : DetailUiState
}
