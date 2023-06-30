package com.tmdb.data.api.implKtor.di.component

import com.tmdb.api.config.url.provider.discover.DiscoverUrlProvider
import com.tmdb.api.config.url.provider.genre.GenreUrlProvider
import com.tmdb.api.config.url.provider.movie.MovieUrlProvider
import com.tmdb.api.config.url.provider.person.PersonUrlProvider


interface ApiComponentDependencies {
    val discoverUrlProvider: DiscoverUrlProvider
    val genreUrlProvider: GenreUrlProvider
    val movieUrlProvider: MovieUrlProvider
    val personUrlProvider: PersonUrlProvider
}
