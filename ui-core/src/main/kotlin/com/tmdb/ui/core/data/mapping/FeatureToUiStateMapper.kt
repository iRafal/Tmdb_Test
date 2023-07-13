package com.tmdb.ui.core.data.mapping

import com.tmdb.data.model.state.DataState
import com.tmdb.ui.core.data.UiState

typealias DataStateToUiStateMapper<T, R> = (DataState<T>?) -> UiState<R>

fun <T, R> mapDataStateToUiState(dataMapper: (T) -> R): DataStateToUiStateMapper<T, R> {
    return { featureState ->
        when (featureState) {
            is DataState.Success -> UiState.Success(dataMapper(featureState.data))
            is DataState.Error -> UiState.Error()
            is DataState.NetworkError -> UiState.NetworkError()
            else -> UiState.Loading()
        }
    }
}
