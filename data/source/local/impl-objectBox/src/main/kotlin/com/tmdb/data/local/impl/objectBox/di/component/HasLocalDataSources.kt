package com.tmdb.data.local.impl.objectBox.di.component

import com.tmdb.data.source.remote.contract.MovieLocalDataSource


interface HasLocalDataSources {
    val movieLocalDataSource: MovieLocalDataSource
}
