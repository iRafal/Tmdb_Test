package com.tmdb.store.state.di.module

import com.tmdb.store.state.home.MoviesDataToFeatureStateMapper
import com.tmdb.store.state.mapping.mapDataToFeatureStateImpl
import dagger.Module
import dagger.Provides


@Module
object HomeFeatureMappingModule {

    @Provides
    fun moviesDataToFeatureStateMapper(): @JvmSuppressWildcards MoviesDataToFeatureStateMapper = ::mapDataToFeatureStateImpl
}
