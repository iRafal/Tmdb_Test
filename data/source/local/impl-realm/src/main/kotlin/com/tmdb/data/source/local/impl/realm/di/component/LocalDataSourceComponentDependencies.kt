package com.tmdb.data.source.local.impl.realm.di.component

import com.tmdb.data.db.realm.movie.dao.MovieDao
import com.tmdb.utill.di.qualifiers.ApplicationScope

interface LocalDataSourceComponentDependencies {
    @get:ApplicationScope
    val movieDao: MovieDao
}
