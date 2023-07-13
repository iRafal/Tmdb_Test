package com.tmdb.data.source.remote.impl.di.component

import com.tmdb.api.implRetrofit.di.component.ApiComponentStore

object  RemoteDataSourceComponentStore {
    private var _component: RemoteDataSourceComponent? = null
    val component: RemoteDataSourceComponent
        get() {
            if (_component == null) {
                _component = DaggerRemoteDataSourceComponent.builder().apiInjections(ApiComponentStore.component).build()
            }
            return checkNotNull(_component)
        }

    fun clean() {
        _component = null
        ApiComponentStore.clean()
    }
}
