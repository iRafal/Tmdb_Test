package com.tmdb.feature.home.reducer.di.component

import com.tmdb.data.model.mapping.movie.MoviesApiToDataStateMapper

interface HomeFeatureReducerComponentDependencies {
    val moviesApiToDataStateMapper: @JvmSuppressWildcards MoviesApiToDataStateMapper
}
