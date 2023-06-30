package com.tmdb.data.source.local.impl.di.component

import com.tmdb.data.db.room.movie.MovieDao

interface LocalDataSourceComponentDependencies {
    val movieDao: MovieDao
}
