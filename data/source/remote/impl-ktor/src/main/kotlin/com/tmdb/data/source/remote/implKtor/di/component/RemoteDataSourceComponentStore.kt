package com.tmdb.data.source.remote.implKtor.di.component

import com.tmdb.data.api.implKtor.di.component.ApiComponentStore
import com.tmdb.data.api.implKtor.discover.DiscoverApi
import com.tmdb.data.api.implKtor.genre.GenreApi
import com.tmdb.data.api.implKtor.movie.MovieApi
import com.tmdb.data.api.implKtor.person.PersonApi

object RemoteDataSourceComponentStore {
    private var _component: RemoteDataSourceComponent? = null
    val component: RemoteDataSourceComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        ApiComponentStore.init()

        val dependencies = object : RemoteDataSourceComponentDependencies {
            override val discoverApi: DiscoverApi
                get() = ApiComponentStore.component.discoverApi

            override val genreApi: GenreApi
                get() = ApiComponentStore.component.genreApi

            override val movieApi: MovieApi
                get() = ApiComponentStore.component.movieApi

            override val personApi: PersonApi
                get() = ApiComponentStore.component.personApi
        }
        _component = DaggerRemoteDataSourceComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
        ApiComponentStore.clean()
    }
}
