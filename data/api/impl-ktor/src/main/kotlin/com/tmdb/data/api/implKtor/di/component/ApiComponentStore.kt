package com.tmdb.data.api.implKtor.di.component

import com.tmdb.api.config.url.di.component.ApiConfigComponentStore
import com.tmdb.api.config.url.provider.discover.DiscoverUrlProvider
import com.tmdb.api.config.url.provider.genre.GenreUrlProvider
import com.tmdb.api.config.url.provider.movie.MovieUrlProvider
import com.tmdb.api.config.url.provider.person.PersonUrlProvider

object ApiComponentStore {
    private var _component: ApiComponent? = null
    val component: ApiComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        ApiConfigComponentStore.init()

        val dependencies = object : ApiComponentDependencies {
            override val discoverUrlProvider: DiscoverUrlProvider
                get() = ApiConfigComponentStore.component.discoverUrlProvider

            override val genreUrlProvider: GenreUrlProvider
                get() = ApiConfigComponentStore.component.genreUrlProvider

            override val movieUrlProvider: MovieUrlProvider
                get() = ApiConfigComponentStore.component.movieUrlProvider

            override val personUrlProvider: PersonUrlProvider
                get() = ApiConfigComponentStore.component.personUrlProvider

        }
        _component = DaggerApiComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}