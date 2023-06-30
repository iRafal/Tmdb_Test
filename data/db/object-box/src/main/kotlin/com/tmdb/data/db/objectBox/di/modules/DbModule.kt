package com.tmdb.data.db.objectBox.di.modules

import android.content.Context
import com.tmdb.data.db.objectBox.di.ObjectBoxConfig
import com.tmdb.data.db.objectBox.movie.MovieEntity
import com.tmdb.data.db.objectBox.movie.dao.MovieDao
import com.tmdb.data.db.objectBox.movie.dao.MovieDaoImpl
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore

@Module
object DbModule {

    @[Provides ApplicationScope]
    fun dataBase(@ApplicationContext appContext:  Context): BoxStore = ObjectBoxConfig.store(appContext)

    @[Provides ApplicationScope]
    fun movieBox(boxStore: BoxStore): Box<MovieEntity> = ObjectBoxConfig.moviesBox(boxStore)

    @[Provides ApplicationScope]
    fun movieDao(impl: MovieDaoImpl): MovieDao = impl
}
