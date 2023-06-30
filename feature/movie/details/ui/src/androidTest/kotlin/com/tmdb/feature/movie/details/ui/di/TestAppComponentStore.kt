package com.tmdb.feature.movie.details.ui.di

import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponentStore
import com.tmdb.store.app.di.component.AppStoreComponentStore

object TestAppComponentStore {
    private var _component: TestAppComponent? = null
    val component: TestAppComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        _component = DaggerTestAppComponent.builder().build()
        AppStoreComponentStore.init(component.instrumentationContext)
        MovieDetailsFeatureComponentStore.init(AppStoreComponentStore.component.appStore)
    }

    fun clean() {
        _component = null
        AppStoreComponentStore.clean()
        MovieDetailsFeatureComponentStore.clean()
    }
}
