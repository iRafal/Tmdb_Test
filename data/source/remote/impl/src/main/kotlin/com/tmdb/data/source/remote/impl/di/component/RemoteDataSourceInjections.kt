package com.tmdb.data.source.remote.impl.di.component

import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource

interface RemoteDataSourceInjections {
    val discoverRemoteDataSource: DiscoverRemoteDataSource
    val genreRemoteDataSource: GenreRemoteDataSource
    val movieRemoteDataSource: MovieRemoteDataSource
    val personRemoteDataSource: PersonRemoteDataSource
}
