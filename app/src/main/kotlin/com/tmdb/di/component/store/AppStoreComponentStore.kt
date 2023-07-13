package com.tmdb.di.component.store

import android.content.Context
import com.tmdb.data.source.local.impl.di.component.LocalDataSourceComponentStore
import com.tmdb.data.source.remote.implKtor.di.component.RemoteDataSourceComponentStore
import com.tmdb.utill.di.qualifiers.ApplicationContext

object AppStoreComponentStore {
    private var _component: AppStoreComponent? = null
    val component: AppStoreComponent
        get() = checkNotNull(_component)

    fun init(@ApplicationContext applicationContext: Context) {
        if (_component != null) return

        LocalDataSourceComponentStore.init(applicationContext)

        _component = DaggerAppStoreComponent.builder()
            .appContext(applicationContext)
            .localDataSourceInjections(LocalDataSourceComponentStore.component)
            .remoteDataSourceInjections(RemoteDataSourceComponentStore.component)
            .build()
    }

    fun clean() {
        _component = null
        LocalDataSourceComponentStore.clean()
        RemoteDataSourceComponentStore.clean()
    }
}
