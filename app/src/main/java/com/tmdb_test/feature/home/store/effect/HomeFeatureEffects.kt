package com.tmdb_test.feature.home.store.effect

import com.tmdb_test.feature.home.store.HomeAction
import com.tmdb_test.feature.home.store.HomeFeature
import com.tmdb_test.store.base.Action
import com.tmdb_test.store.base.Effect
import com.tmdb_test.store.base.Effects
import com.tmdb_test.store.env.AppEnv
import com.tmdb_test.util.MoviesApiResponseToDataStateMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext


object HomeFeatureEffects {
    fun loadMovieSections(
        mapper: MoviesApiResponseToDataStateMapper
    ) = mainEffect {
        withContext(Dispatchers.IO) {
            val nowPlayingMovies = async { env.network.movieSource.nowPlayingMovies() }.await()
            val nowPopularMovies = async { env.network.movieSource.nowPopularMovies() }.await()
            val topRatedMovies = async { env.network.movieSource.topRatedMovies() }.await()
            val upcomingMovies = async { env.network.movieSource.upcomingMovies() }.await()

            HomeAction.MovieSectionsLoaded(
                nowPlayingMovies = mapper(nowPlayingMovies),
                nowPopularMovies = mapper(nowPopularMovies),
                topRatedMovies = mapper(topRatedMovies),
                upcomingMovies = mapper(upcomingMovies),
            )
        }
    }

    private fun mainEffect(
        effectExecutorScope: suspend Effect.Executor.Scope<AppEnv>.() -> Action
    ): Effect<AppEnv> = Effects.effect(effectExecutorScope, HomeFeature)
}
