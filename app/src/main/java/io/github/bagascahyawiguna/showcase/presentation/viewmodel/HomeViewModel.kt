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

    private var currentPage = 0
    private var isFetchingPage = false

    init {
        loadShows()
    }

    fun loadShows() {
        currentPage = 0
        isFetchingPage = true
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            repository.getShows(page = currentPage)
                .onSuccess { shows ->
                    isFetchingPage = false
                    _uiState.value = HomeUiState.Success(
                        shows = shows,
                        isEndReached = shows.isEmpty()
                    )
                }
                .onFailure { throwable ->
                    isFetchingPage = false
                    val errorMessage = throwable.localizedMessage ?: "Failed to load TV shows"
                    _uiState.value = HomeUiState.Error(errorMessage)
                }
        }
    }

    fun loadNextPage() {
        val currentState = _uiState.value as? HomeUiState.Success ?: return
        if (isFetchingPage || currentState.isLoadingNextPage || currentState.isEndReached) return

        isFetchingPage = true
        _uiState.value = currentState.copy(
            isLoadingNextPage = true,
            paginationError = null
        )

        viewModelScope.launch {
            val nextPage = currentPage + 1
            repository.getShows(page = nextPage)
                .onSuccess { newShows ->
                    isFetchingPage = false
                    if (newShows.isEmpty()) {
                        _uiState.value = currentState.copy(
                            isLoadingNextPage = false,
                            isEndReached = true
                        )
                    } else {
                        currentPage = nextPage
                        _uiState.value = HomeUiState.Success(
                            shows = currentState.shows + newShows,
                            isLoadingNextPage = false,
                            isEndReached = false,
                            paginationError = null
                        )
                    }
                }
                .onFailure { throwable ->
                    isFetchingPage = false
                    val errorMsg = throwable.localizedMessage ?: "Failed to load more shows"
                    _uiState.value = currentState.copy(
                        isLoadingNextPage = false,
                        paginationError = errorMsg
                    )
                }
        }
    }

    fun retryNextPage() {
        loadNextPage()
    }

    fun retry() {
        val currentState = _uiState.value
        if (currentState is HomeUiState.Success && currentState.paginationError != null) {
            retryNextPage()
        } else {
            loadShows()
        }
    }
}
