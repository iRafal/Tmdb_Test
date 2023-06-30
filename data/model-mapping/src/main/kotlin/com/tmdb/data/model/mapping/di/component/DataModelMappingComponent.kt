package com.tmdb.data.model.mapping.di.component

import com.tmdb.data.model.mapping.di.module.MovieApiMappingModule
import com.tmdb.data.model.mapping.movie.MoviesApiToDataStateMapper
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(modules = [MovieApiMappingModule::class], dependencies = [DataModelMappingComponentDependencies::class])]
interface DataModelMappingComponent {

    val moviesApiToDataStateMapper: @JvmSuppressWildcards MoviesApiToDataStateMapper

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: DataModelMappingComponentDependencies): Builder
        fun build(): DataModelMappingComponent
    }
}
