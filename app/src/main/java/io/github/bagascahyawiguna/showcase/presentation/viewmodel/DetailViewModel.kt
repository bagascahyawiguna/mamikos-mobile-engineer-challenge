package io.github.bagascahyawiguna.showcase.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.bagascahyawiguna.showcase.common.network.NetworkModule
import io.github.bagascahyawiguna.showcase.data.repository.TvShowRepositoryImpl
import io.github.bagascahyawiguna.showcase.domain.repository.TvShowRepository
import io.github.bagascahyawiguna.showcase.presentation.state.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: TvShowRepository = TvShowRepositoryImpl(NetworkModule.tvMazeApi)
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private var currentShowId: Int? = null

    fun loadShowDetail(id: Int) {
        currentShowId = id
        _uiState.value = DetailUiState.Loading
        viewModelScope.launch {
            repository.getShowDetail(id)
                .onSuccess { show ->
                    _uiState.value = DetailUiState.Success(show)
                }
                .onFailure { throwable ->
                    val errorMessage = throwable.localizedMessage ?: "Failed to load show detail"
                    _uiState.value = DetailUiState.Error(errorMessage)
                }
        }
    }

    fun retry() {
        currentShowId?.let { loadShowDetail(it) }
    }
}
