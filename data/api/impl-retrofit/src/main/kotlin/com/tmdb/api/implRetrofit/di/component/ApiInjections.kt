package com.tmdb.api.implRetrofit.di.component

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.api.implRetrofit.discover.DiscoverApi
import com.tmdb.api.implRetrofit.genre.GenreApi
import com.tmdb.api.implRetrofit.movie.MovieApi
import com.tmdb.api.implRetrofit.person.PersonApi
import com.tmdb.utill.di.qualifiers.ApplicationScope


interface ApiInjections {
    @get:ApplicationScope
    val discoverApi: DiscoverApi

    @get:ApplicationScope
    val genreApi: GenreApi

    @get:ApplicationScope
    val movieApi: MovieApi

    @get:ApplicationScope
    val personApi: PersonApi

    val imageUrlProvider: ImageUrlProvider
}
