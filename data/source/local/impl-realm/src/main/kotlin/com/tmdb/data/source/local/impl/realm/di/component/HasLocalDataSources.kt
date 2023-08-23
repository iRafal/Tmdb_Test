package com.tmdb.data.source.local.impl.realm.di.component

import com.tmdb.data.source.remote.contract.MovieLocalDataSource


interface HasLocalDataSources {
    val movieLocalDataSource: MovieLocalDataSource
}
