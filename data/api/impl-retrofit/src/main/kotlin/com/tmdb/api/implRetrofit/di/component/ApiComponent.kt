package com.tmdb.api.implRetrofit.di.component

import com.tmdb.api.implRetrofit.di.module.ApiModule
import com.tmdb.api.implRetrofit.discover.DiscoverApi
import com.tmdb.api.implRetrofit.genre.GenreApi
import com.tmdb.api.implRetrofit.movie.MovieApi
import com.tmdb.api.implRetrofit.person.PersonApi
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
