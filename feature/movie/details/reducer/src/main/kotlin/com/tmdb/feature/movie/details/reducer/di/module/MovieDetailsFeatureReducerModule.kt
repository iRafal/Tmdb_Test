package com.tmdb.feature.movie.details.reducer.di.module

import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSliceImpl
import dagger.Binds
import dagger.Module

@Module
interface MovieDetailsFeatureReducerModule {

    @Binds
    fun movieDetailsFeatureSlice(impl: MovieDetailsFeatureSliceImpl): MovieDetailsFeatureSlice
}
