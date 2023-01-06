package com.tmdb_test.feature.home.store.reducer

import com.tmdb_test.feature.home.store.HomeAction
import com.tmdb_test.feature.home.store.HomeFeatureState
import com.tmdb_test.feature.mapping.MoviesDataToFeatureStateMapper
import com.tmdb_test.store.base.Effect
import com.tmdb_test.store.base.Effects
import com.tmdb_test.store.env.AppEnv


fun HomeFeatureState.reduceMovieSectionsLoaded(
    action: HomeAction.MovieSectionsLoaded,
    mapper: MoviesDataToFeatureStateMapper
): Pair<HomeFeatureState, Effect<AppEnv>?> {
    val newState = this.copy(
        nowPlayingMoviesState = mapper(action.nowPlayingMovies),
        nowPopularMoviesState = mapper(action.nowPopularMovies),
        topRatedMoviesState = mapper(action.topRatedMovies),
        upcomingMoviesState = mapper(action.upcomingMovies),
    )
    return newState to Effects.empty()
}