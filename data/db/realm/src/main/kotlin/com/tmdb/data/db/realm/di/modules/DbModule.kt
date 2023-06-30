package com.tmdb.data.db.realm.di.modules

import android.content.Context
import com.tmdb.data.db.realm.di.MoviesRealmDbConfig
import com.tmdb.data.db.realm.movie.dao.MovieDao
import com.tmdb.data.db.realm.movie.dao.MovieDaoImpl
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration


@Module
object DbModule {

    @[ApplicationScope Provides]
    fun providesRealmConfig(
        @ApplicationContext applicationContext: Context
    ): RealmConfiguration {
        MoviesRealmDbConfig.initRealm(applicationContext)
        return MoviesRealmDbConfig.realmConfig()
    }

    @[ApplicationScope Provides]
    fun dataBase(realmConfig: RealmConfiguration): Realm = Realm.getInstance(realmConfig)

    @[ApplicationScope Provides]
    fun movieDao(impl: MovieDaoImpl): MovieDao = impl
}
