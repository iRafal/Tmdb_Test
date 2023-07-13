package com.tmdb.feature.home.ui.data.mapping

import com.tmdb.data.model.MovieDataModel
import com.tmdb.feature.home.ui.data.model.HomeMovieSection.NOW_PLAYING
import com.tmdb.feature.home.ui.data.model.HomeMovieSection.NOW_POPULAR
import com.tmdb.feature.home.ui.data.model.HomeMovieSection.TOP_RATED
import com.tmdb.feature.home.ui.data.model.HomeMovieSection.UPCOMING
import com.tmdb.feature.home.ui.data.model.HomeUiData
import com.tmdb.store.state.home.HomeFeatureState
import com.tmdb.ui.core.data.UiState
import com.tmdb.ui.core.data.mapping.DataStateToUiStateMapper


typealias HomeDataStateToUiStateMapper = DataStateToUiStateMapper<List<MovieDataModel>, List<HomeUiData.Movie>>

typealias HomeFeatureStateToUiStateMapper = (featureState: HomeFeatureState) -> HomeUiData

fun homeFeatureToUiStateMapperImpl(
    homeDataStateToUiStateMapper: HomeDataStateToUiStateMapper
): HomeFeatureStateToUiStateMapper {

    fun HomeFeatureState.MoviesGroup.mapToUiState(): UiState<List<HomeUiData.Movie>> {
        return if (this.isLoading) {
            UiState.Loading()
        } else {
            homeDataStateToUiStateMapper(this.movies)
        }
    }

    return { featureState ->
        val nowPlayingMoviesState = featureState.nowPlayingMovies.mapToUiState()
        val nowPopularMoviesState = featureState.nowPopularMovies.mapToUiState()
        val topRatedMoviesState = featureState.topRatedMovies.mapToUiState()
        val upcomingMoviesState = featureState.upcomingMovies.mapToUiState()

        HomeUiData(
            movieSections = mapOf(
                NOW_PLAYING to nowPlayingMoviesState,
                NOW_POPULAR to nowPopularMoviesState,
                TOP_RATED to topRatedMoviesState,
                UPCOMING to upcomingMoviesState
            )
        )
    }
}
