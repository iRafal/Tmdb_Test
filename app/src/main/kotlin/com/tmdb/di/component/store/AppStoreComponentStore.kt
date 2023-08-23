package com.tmdb.di.component.store

import android.content.Context
import com.tmdb.data.source.local.impl.di.component.LocalDataSourceComponentStore
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource
import com.tmdb.data.source.remote.implKtor.di.component.RemoteDataSourceComponentStore

internal class AppStoreComponentStore {

    private var _component: AppStoreComponent? = null

    val component: AppStoreComponent
        get() = checkNotNull(_component)

    private val remoteDataSourceComponentStore: RemoteDataSourceComponentStore by lazy { RemoteDataSourceComponentStore() }

    private val localDataSourceComponentStore: LocalDataSourceComponentStore by lazy { LocalDataSourceComponentStore() }

    fun init(applicationContext: Context) {
        if (_component != null) return

        localDataSourceComponentStore.init(applicationContext)

        val dependencies = object : AppStoreComponent.Dependencies {
            override val discoverRemoteDataSource: DiscoverRemoteDataSource
                get() = remoteDataSourceComponentStore.component.discoverRemoteDataSource
            override val genreRemoteDataSource: GenreRemoteDataSource
                get() = remoteDataSourceComponentStore.component.genreRemoteDataSource
            override val movieRemoteDataSource: MovieRemoteDataSource
                get() = remoteDataSourceComponentStore.component.movieRemoteDataSource
            override val personRemoteDataSource: PersonRemoteDataSource
                get() = remoteDataSourceComponentStore.component.personRemoteDataSource
            override val movieLocalDataSource: MovieLocalDataSource
                get() = localDataSourceComponentStore.component.movieLocalDataSource
        }

        _component = DaggerAppStoreComponent.builder()
            .appContext(applicationContext)
            .dependencies(dependencies)
            .build()
    }

    fun clean() {
        _component = null
        remoteDataSourceComponentStore.clean()
        localDataSourceComponentStore.clean()
    }
}
