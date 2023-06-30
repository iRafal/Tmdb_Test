package com.tmdb.data.source.remote.impl.di.component

import com.tmdb.api.implRetrofit.di.component.ApiComponentStore
import com.tmdb.api.implRetrofit.discover.DiscoverApi
import com.tmdb.api.implRetrofit.genre.GenreApi
import com.tmdb.api.implRetrofit.movie.MovieApi
import com.tmdb.api.implRetrofit.person.PersonApi

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
