package com.tmdb.data.db.objectBox.di.component

import com.tmdb.data.db.objectBox.di.modules.DbModule
import com.tmdb.data.db.objectBox.movie.dao.MovieDao
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component


@[ApplicationScope Component(modules = [DbModule::class], dependencies = [DbComponentDependencies::class])]
interface DbComponent {

    @get:ApplicationScope
    val movieDao: MovieDao

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: DbComponentDependencies): Builder
        fun build(): DbComponent
    }
}
