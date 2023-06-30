package com.tmdb.store.reducer.app.di.component

import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.home.reducer.di.component.HomeFeatureReducerComponentStore
import com.tmdb.feature.movie.details.reducer.MovieDetailsFeatureSlice
import com.tmdb.feature.movie.details.reducer.di.component.MovieDetailsFeatureReducerComponentStore

object AppReducerComponentStore {
    private var _component: AppReducerComponent? = null
    val component: AppReducerComponent
        get() = checkNotNull(_component)

    fun init() {
        HomeFeatureReducerComponentStore.init()
        MovieDetailsFeatureReducerComponentStore.init()

        val dependencies = object : AppReducerComponentDependencies {
            override val homeFeatureSlice: HomeFeatureSlice
                get() = HomeFeatureReducerComponentStore.component.homeFeatureSlice
            override val movieDetailsFeatureSlice: MovieDetailsFeatureSlice
                get() = MovieDetailsFeatureReducerComponentStore.component.movieDetailsFeatureSlice
        }
        _component = DaggerAppReducerComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
        HomeFeatureReducerComponentStore.clean()
        MovieDetailsFeatureReducerComponentStore.clean()
    }
}
