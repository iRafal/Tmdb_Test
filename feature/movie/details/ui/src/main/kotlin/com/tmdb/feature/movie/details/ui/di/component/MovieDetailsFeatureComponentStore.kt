package com.tmdb.feature.movie.details.ui.di.component

import com.tmdb.store.app.AppStore

object MovieDetailsFeatureComponentStore {
    private var _component: MovieDetailsFeatureComponent? = null
    val component: MovieDetailsFeatureComponent
        get() = checkNotNull(_component)

    fun init(appStore: AppStore) {
        if (_component != null) return

        val dependencies = object : MovieDetailsFeatureComponentDependencies {
            override val appStore: AppStore
                get() = appStore
        }
        _component = DaggerMovieDetailsFeatureComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}
