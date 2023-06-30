package com.tmdb.store.env.di.component

import android.content.Context
import com.tmdb.data.source.local.impl.di.component.LocalDataSourceComponentStore
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource
import com.tmdb.data.source.remote.implKtor.di.component.RemoteDataSourceComponentStore
import com.tmdb.utill.di.qualifiers.ApplicationContext

object AppEnvComponentStore {
    private var _component: AppEnvComponent? = null
    val component: AppEnvComponent
        get() = checkNotNull(_component)

    fun init(@ApplicationContext applicationContext: Context) {
        if (_component != null) return

        RemoteDataSourceComponentStore.init()
        val remoteDataSourceComponent = RemoteDataSourceComponentStore.component

        LocalDataSourceComponentStore.init(applicationContext)
        val localDataSourceComponent = LocalDataSourceComponentStore.component

        val dependencies = object : AppEnvComponentDependencies {
            override val discoverRemoteDataSource: DiscoverRemoteDataSource
                get() = remoteDataSourceComponent.discoverRemoteDataSource

            override val genreRemoteDataSource: GenreRemoteDataSource
                get() = remoteDataSourceComponent.genreRemoteDataSource

            override val movieRemoteDataSource: MovieRemoteDataSource
                get() = remoteDataSourceComponent.movieRemoteDataSource

            override val personRemoteDataSource: PersonRemoteDataSource
                get() = remoteDataSourceComponent.personRemoteDataSource

            override val movieLocalDataSource: MovieLocalDataSource
                get() = localDataSourceComponent.movieLocalDataSource
        }
        _component = DaggerAppEnvComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
        LocalDataSourceComponentStore.clean()
        RemoteDataSourceComponentStore.clean()
    }
}