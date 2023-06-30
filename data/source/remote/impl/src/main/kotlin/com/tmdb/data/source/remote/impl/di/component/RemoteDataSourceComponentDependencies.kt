package com.tmdb.data.source.remote.impl.di.component

import com.tmdb.api.implRetrofit.discover.DiscoverApi
import com.tmdb.api.implRetrofit.genre.GenreApi
import com.tmdb.api.implRetrofit.movie.MovieApi
import com.tmdb.api.implRetrofit.person.PersonApi

interface RemoteDataSourceComponentDependencies {
    val discoverApi: DiscoverApi
    val genreApi: GenreApi
    val movieApi: MovieApi
    val personApi: PersonApi
}
