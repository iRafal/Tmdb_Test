package com.tmdb.store.reducer.app.di.module

import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.store.reducer.app.AppReducer
import com.tmdb.store.reducer.app.createAppReducer
import dagger.Module
import dagger.Provides


@Module
object AppReducerModule {

    @Provides
    fun appReducer(
        homeFeatureSlice: HomeFeatureSlice,
        movieDetailsFeatureSlice: MovieDetailsFeatureSlice
    ): @JvmSuppressWildcards AppReducer = createAppReducer(homeFeatureSlice, movieDetailsFeatureSlice)
}
