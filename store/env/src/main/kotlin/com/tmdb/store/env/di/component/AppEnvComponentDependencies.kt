package com.tmdb.store.env.di.component

import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource

interface AppEnvComponentDependencies {
    val discoverRemoteDataSource: DiscoverRemoteDataSource
    val genreRemoteDataSource: GenreRemoteDataSource
    val movieRemoteDataSource: MovieRemoteDataSource
    val personRemoteDataSource: PersonRemoteDataSource

    val movieLocalDataSource: MovieLocalDataSource
}