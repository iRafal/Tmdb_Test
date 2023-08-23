package com.tmdb.feature.home.reducer

import com.tmdb.store.action.HomeAction
import com.tmdb.store.base.Effect
import com.tmdb.store.base.Effects
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.state.HomeFeatureState

fun HomeFeatureState.reduceReloadUpcomingMovies(
    action: HomeAction.ReloadUpcomingMovies
): Pair<HomeFeatureState, Effect<AppEnv>?> {
    val newState = this.copy(upcomingMovies.copyAsLoading)
    return newState to Effects.empty() // TODO effect
}