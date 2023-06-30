package com.tmdb.feature.home.ui.di

import com.tmdb.feature.home.ui.di.component.HomeFeatureComponentStore
import com.tmdb.store.app.di.component.AppStoreComponentStore

object TestAppComponentStore {
    private var _component: TestAppComponent? = null
    val component: TestAppComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        _component = DaggerTestAppComponent.builder().build()
        AppStoreComponentStore.init(component.instrumentationContext)
        HomeFeatureComponentStore.init(AppStoreComponentStore.component.appStore)
    }

    fun clean() {
        _component = null
        AppStoreComponentStore.clean()
        HomeFeatureComponentStore.clean()
    }
}
