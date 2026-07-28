package io.github.bagascahyawiguna.showcase.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.bagascahyawiguna.showcase.common.network.NetworkModule
import io.github.bagascahyawiguna.showcase.data.repository.TvShowRepositoryImpl
import io.github.bagascahyawiguna.showcase.domain.repository.TvShowRepository
import io.github.bagascahyawiguna.showcase.presentation.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TvShowRepository = TvShowRepositoryImpl(NetworkModule.tvMazeApi)
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadShows()
    }

    fun loadShows() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            repository.getShows(page = 0)
                .onSuccess { shows ->
                    _uiState.value = HomeUiState.Success(shows)
                }
                .onFailure { throwable ->
                    val errorMessage = throwable.localizedMessage ?: "Failed to load TV shows"
                    _uiState.value = HomeUiState.Error(errorMessage)
                }
        }
    }

    fun retry() {
        loadShows()
    }
}
