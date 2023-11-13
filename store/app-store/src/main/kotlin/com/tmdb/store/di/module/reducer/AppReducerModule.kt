package com.tmdb.store.di.module.reducer

import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.store.AppReducer
import com.tmdb.store.AppReducerImpl
import dagger.Module
import dagger.Provides


@Module(includes = [HomeFeatureReducerModule::class])
object AppReducerModule {

    @get:Provides
    val movieDetailsFeatureSlice = MovieDetailsFeatureSlice()

    @Provides
    fun appReducer(
        movieDetailsFeatureSlice: MovieDetailsFeatureSlice,
        homeFeatureSlice: HomeFeatureSlice,
    ): AppReducer = AppReducerImpl(homeFeatureSlice, movieDetailsFeatureSlice)
}
