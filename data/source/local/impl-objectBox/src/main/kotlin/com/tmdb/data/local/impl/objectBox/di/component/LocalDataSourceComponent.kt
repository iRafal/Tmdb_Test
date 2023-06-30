package com.tmdb.data.local.impl.objectBox.di.component

import com.tmdb.data.local.impl.objectBox.di.module.LocalDataSourceModule
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component


@[ApplicationScope Component(modules = [LocalDataSourceModule::class], dependencies = [LocalDataSourceComponentDependencies::class])]
interface LocalDataSourceComponent {
    val movieLocalDataSource: MovieLocalDataSource

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: LocalDataSourceComponentDependencies): Builder
        fun build(): LocalDataSourceComponent
    }
}
