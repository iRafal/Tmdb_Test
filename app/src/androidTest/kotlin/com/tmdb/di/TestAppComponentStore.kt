package com.tmdb.di

import com.tmdb.di.component.store.AppStoreComponentStore


object TestAppComponentStore {
    private var _component: TestAppComponent? = null
    val component: TestAppComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        _component = DaggerTestAppComponent.builder().build()
        AppStoreComponentStore.init(component.instrumentationContext)
    }

    fun clean() {
        _component = null
        AppStoreComponentStore.clean()
    }
}
