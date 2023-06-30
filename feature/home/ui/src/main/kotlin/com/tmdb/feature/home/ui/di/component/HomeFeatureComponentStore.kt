package com.tmdb.feature.home.ui.di.component

import com.tmdb.store.app.AppStore

object HomeFeatureComponentStore {
    private var _component: HomeFeatureComponent? = null
    val component: HomeFeatureComponent
        get() = checkNotNull(_component)

    fun init(appStore: AppStore) {
        if (_component != null) return
        val dependencies = object : HomeFeatureComponentDependencies {
            override val appStore: AppStore
                get() = appStore
        }
        _component = DaggerHomeFeatureComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}