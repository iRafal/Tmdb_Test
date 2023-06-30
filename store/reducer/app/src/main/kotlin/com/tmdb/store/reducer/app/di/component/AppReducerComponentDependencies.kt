package com.tmdb.store.reducer.app.di.component

import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice

interface AppReducerComponentDependencies {
    val homeFeatureSlice: HomeFeatureSlice
    val movieDetailsFeatureSlice: MovieDetailsFeatureSlice
}
