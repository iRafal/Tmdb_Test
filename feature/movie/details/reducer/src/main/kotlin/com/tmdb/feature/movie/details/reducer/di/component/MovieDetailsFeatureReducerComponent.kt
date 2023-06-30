package com.tmdb.feature.movie.details.reducer.di.component

import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.feature.movie.details.reducer.di.module.MovieDetailsFeatureReducerModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(dependencies = [MovieDetailsFeatureReducerComponentDependencies::class], modules = [MovieDetailsFeatureReducerModule::class])]
interface MovieDetailsFeatureReducerComponent {

    val movieDetailsFeatureSlice: MovieDetailsFeatureSlice

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: MovieDetailsFeatureReducerComponentDependencies): Builder
        fun build(): MovieDetailsFeatureReducerComponent
    }
}
