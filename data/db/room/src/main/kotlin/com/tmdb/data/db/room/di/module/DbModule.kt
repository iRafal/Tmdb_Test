package com.tmdb.data.db.room.di.module

import android.content.Context
import com.tmdb.data.db.room.MovieDb
import com.tmdb.data.db.room.movie.MovieDao
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Module
import dagger.Provides


@Module
object DbModule {

    @[Provides ApplicationScope]
    fun dataBase(@ApplicationContext appContext: Context): MovieDb = MovieDb.getInstance(appContext)

    @[Provides ApplicationScope]
    fun movieDao(database: MovieDb): MovieDao = database.movieDao()
}
