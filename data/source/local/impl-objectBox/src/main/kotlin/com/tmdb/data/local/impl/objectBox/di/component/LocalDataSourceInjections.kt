package com.tmdb.data.local.impl.objectBox.di.component

import com.tmdb.data.source.remote.contract.MovieLocalDataSource


interface LocalDataSourceInjections {
    val movieLocalDataSource: MovieLocalDataSource
}
