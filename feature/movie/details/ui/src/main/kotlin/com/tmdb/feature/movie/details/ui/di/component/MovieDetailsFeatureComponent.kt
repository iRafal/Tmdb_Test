package com.tmdb.feature.movie.details.ui.di.component

import com.tmdb.feature.movie.details.ui.MovieDetailsViewModel
import com.tmdb.feature.movie.details.ui.di.MovieDetailsFeatureModule
import com.tmdb.ui.core.di.qualifiers.FeatureScope
import dagger.Component


@[FeatureScope Component(modules = [MovieDetailsFeatureModule::class], dependencies = [MovieDetailsFeatureComponentDependencies::class])]
interface MovieDetailsFeatureComponent {

    val movieDetailsViewModel: MovieDetailsViewModel

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: MovieDetailsFeatureComponentDependencies): Builder
        fun build(): MovieDetailsFeatureComponent
    }
}
