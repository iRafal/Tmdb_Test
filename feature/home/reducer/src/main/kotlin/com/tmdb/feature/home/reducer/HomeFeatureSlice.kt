package com.tmdb.feature.home.reducer

import com.tmdb.store.action.HomeAction
import com.tmdb.store.base.Action
import com.tmdb.store.base.Effect
import com.tmdb.store.base.Effects
import com.tmdb.store.base.feature.FeatureReducer
import com.tmdb.store.base.feature.FeatureSlice
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.state.app.AppState
import com.tmdb.store.state.home.HomeFeatureState

interface HomeFeatureSlice : FeatureSlice<AppState, AppEnv, HomeFeatureState>

class HomeFeatureSliceImpl(
    homeFeatureEffects: HomeFeatureEffects
) : HomeFeatureSlice {

    override val reducer: FeatureReducer<AppState, AppEnv, HomeFeatureState> =
        { globalState: AppState,
            action: Action ->
            when (action) {
                is HomeAction -> {
                    globalState.reduce(action, homeFeatureEffects)
                }
                else -> globalState.homeState to Effects.empty()
            }
        }
}

private fun AppState.reduce(
    action: HomeAction,
    homeFeatureEffects: HomeFeatureEffects
): Pair<HomeFeatureState, Effect<AppEnv>?> {
    return when (action) {
        is HomeAction.ReloadNowPlayingMovies -> this.homeState.reduceReloadNowPlayingMovies(action)
        is HomeAction.ReloadNowPopularMovies -> this.homeState.reduceReloadNowPopularMovies(action)
        is HomeAction.ReloadTopRatedMovies -> this.homeState.reduceReloadTopRatedMovies(action)
        is HomeAction.ReloadUpcomingMovies -> this.homeState.reduceReloadUpcomingMovies(action)
        is HomeAction.LoadMovieSections -> {
            this.homeState.reduceLoadMovieSections(action, homeFeatureEffects)
        }
        is HomeAction.MovieSectionsLoaded -> {
            this.homeState.reduceMovieSectionsLoaded(action)
        }
    }
}
