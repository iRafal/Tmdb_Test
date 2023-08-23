package com.tmdb.data.api.implKtor.di.component

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.data.api.implKtor.discover.DiscoverApi
import com.tmdb.data.api.implKtor.genre.GenreApi
import com.tmdb.data.api.implKtor.movie.MovieApi
import com.tmdb.data.api.implKtor.person.PersonApi
import com.tmdb.utill.di.qualifiers.ApplicationScope


interface HasApiServices {
    val discoverApi: DiscoverApi

    val genreApi: GenreApi

    val movieApi: MovieApi

    val personApi: PersonApi

    val imageUrlProvider: ImageUrlProvider
}
