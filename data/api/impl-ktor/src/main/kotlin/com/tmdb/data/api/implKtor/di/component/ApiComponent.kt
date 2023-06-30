package com.tmdb.data.api.implKtor.di.component

import com.tmdb.data.api.implKtor.di.module.ApiModule
import com.tmdb.data.api.implKtor.discover.DiscoverApi
import com.tmdb.data.api.implKtor.genre.GenreApi
import com.tmdb.data.api.implKtor.movie.MovieApi
import com.tmdb.data.api.implKtor.person.PersonApi
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component


@[ApplicationScope Component(modules = [ApiModule::class], dependencies = [ApiComponentDependencies::class])]
interface ApiComponent {
    @get:ApplicationScope
    val discoverApi: DiscoverApi

    @get:ApplicationScope
    val genreApi: GenreApi

    @get:ApplicationScope
    val movieApi: MovieApi

    @get:ApplicationScope
    val personApi: PersonApi

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: ApiComponentDependencies): Builder
        fun build(): ApiComponent
    }
}
