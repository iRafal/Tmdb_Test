package com.tmdb.store.state.app

import androidx.annotation.VisibleForTesting
import com.tmdb.store.state.home.HomeFeatureState
import com.tmdb.store.state.details.MovieDetailsFeatureState


data class AppState(
    val homeState: HomeFeatureState,
    val movieDetailsState: MovieDetailsFeatureState
) {
    companion object {
        fun createInitialState() = INITIAL

        @VisibleForTesting
        val INITIAL = AppState(
            homeState = HomeFeatureState.INITIAL,
            movieDetailsState = MovieDetailsFeatureState.INITIAL
        )
    }
}