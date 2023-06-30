package com.tmdb.data.local.impl.objectBox.di.component

import android.content.Context
import com.tmdb.data.db.objectBox.di.component.DbComponentStore
import com.tmdb.data.db.objectBox.movie.dao.MovieDao
import com.tmdb.utill.di.qualifiers.ApplicationContext

object LocalDataSourceComponentStore {
    private var _component: LocalDataSourceComponent? = null
    val component: LocalDataSourceComponent
        get() = checkNotNull(_component)

    fun init(@ApplicationContext applicationContext: Context) {
        if (_component != null) return

        DbComponentStore.init(applicationContext)

        val dependencies = object : LocalDataSourceComponentDependencies {
            override val movieDao: MovieDao
                get() = DbComponentStore.component.movieDao
        }
        _component = DaggerLocalDataSourceComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
        DbComponentStore.clean()
    }
}
