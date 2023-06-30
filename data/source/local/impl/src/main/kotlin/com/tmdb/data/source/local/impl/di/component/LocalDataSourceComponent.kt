package com.tmdb.data.source.local.impl.di.component

import com.tmdb.data.source.local.impl.di.module.LocalDataSourceModule
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import dagger.Component


@Component(modules = [LocalDataSourceModule::class], dependencies = [LocalDataSourceComponentDependencies::class])
interface LocalDataSourceComponent {
    val movieLocalDataSource: MovieLocalDataSource

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: LocalDataSourceComponentDependencies): Builder
        fun build(): LocalDataSourceComponent
    }
}
