package io.github.bagascahyawiguna.showcase.presentation.state

import io.github.bagascahyawiguna.showcase.domain.model.TvShow

sealed interface HomeUiState {
    object Loading : HomeUiState

    data class Success(
        val shows: List<TvShow>,
        val isLoadingNextPage: Boolean = false,
        val paginationError: String? = null,
        val isEndReached: Boolean = false
    ) : HomeUiState

    data class Error(val message: String) : HomeUiState
}
