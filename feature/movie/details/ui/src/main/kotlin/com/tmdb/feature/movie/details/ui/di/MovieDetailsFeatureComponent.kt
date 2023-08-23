package com.tmdb.feature.movie.details.ui.di

import com.tmdb.feature.movie.details.ui.MovieDetailsViewModel
import com.tmdb.store.AppStore
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

interface MovieDetailsFeatureComponentDependencies {
    val appStore: AppStore
}

interface MovieDetailsFeatureComponentProvider {
    val movieDetailsFeatureComponent: MovieDetailsFeatureComponent
}
