package com.tmdb.store.di.module.reducer

import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.store.AppReducer
import com.tmdb.store.createAppReducer
import dagger.Module
import dagger.Provides


@Module(includes = [HomeFeatureReducerModule::class])
object AppReducerModule {

    @Provides
    fun appReducer(
        homeFeatureSlice: HomeFeatureSlice,
    ): @JvmSuppressWildcards AppReducer = createAppReducer(homeFeatureSlice, MovieDetailsFeatureSlice)
}
