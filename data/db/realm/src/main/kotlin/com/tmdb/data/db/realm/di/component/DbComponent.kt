package com.tmdb.data.db.realm.di.component

import com.tmdb.data.db.realm.di.modules.DbModule
import com.tmdb.data.db.realm.movie.dao.MovieDao
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component


@[ApplicationScope Component(modules = [DbModule::class], dependencies = [DbComponentDependencies::class])]
interface DbComponent {

    val movieDao: MovieDao

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: DbComponentDependencies): Builder
        fun build(): DbComponent
    }
}
