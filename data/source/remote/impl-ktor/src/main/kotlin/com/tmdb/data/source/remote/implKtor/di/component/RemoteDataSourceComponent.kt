package com.tmdb.data.source.remote.implKtor.di.component

import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource
import com.tmdb.data.source.remote.implKtor.di.module.RemoteDataSourceModule
import dagger.Component


@Component(modules = [RemoteDataSourceModule::class], dependencies = [RemoteDataSourceComponentDependencies::class])
interface RemoteDataSourceComponent {
    val discoverRemoteDataSource: DiscoverRemoteDataSource
    val genreRemoteDataSource: GenreRemoteDataSource
    val movieRemoteDataSource: MovieRemoteDataSource
    val personRemoteDataSource: PersonRemoteDataSource

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: RemoteDataSourceComponentDependencies): Builder
        fun build(): RemoteDataSourceComponent
    }
}
