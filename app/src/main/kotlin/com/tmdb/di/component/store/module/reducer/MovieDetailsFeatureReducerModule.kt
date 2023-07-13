package com.tmdb.di.component.store.module.reducer

import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSliceImpl
import dagger.Module
import dagger.Provides

@Module
object MovieDetailsFeatureReducerModule {

    @Provides
    fun movieDetailsFeatureSlice(): @JvmSuppressWildcards MovieDetailsFeatureSlice = MovieDetailsFeatureSliceImpl()
}
