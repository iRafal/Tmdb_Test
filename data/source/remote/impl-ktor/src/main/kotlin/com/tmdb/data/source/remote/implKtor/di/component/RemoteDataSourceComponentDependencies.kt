package com.tmdb.data.source.remote.implKtor.di.component

import com.tmdb.data.api.implKtor.discover.DiscoverApi
import com.tmdb.data.api.implKtor.genre.GenreApi
import com.tmdb.data.api.implKtor.movie.MovieApi
import com.tmdb.data.api.implKtor.person.PersonApi

interface RemoteDataSourceComponentDependencies {
    val discoverApi: DiscoverApi
    val genreApi: GenreApi
    val movieApi: MovieApi
    val personApi: PersonApi
}
