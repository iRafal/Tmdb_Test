package com.tmdb.data.local.impl.objectBox.di.component

import com.tmdb.data.db.objectBox.movie.dao.MovieDao
import com.tmdb.utill.di.qualifiers.ApplicationScope

interface LocalDataSourceComponentDependencies {
    @get:ApplicationScope
    val movieDao: MovieDao
}
