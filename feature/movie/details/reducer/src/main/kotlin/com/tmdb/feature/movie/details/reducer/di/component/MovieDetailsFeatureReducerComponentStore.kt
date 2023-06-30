package com.tmdb.feature.movie.details.reducer.di.component


object MovieDetailsFeatureReducerComponentStore {
    private var _component: MovieDetailsFeatureReducerComponent? = null
    val component: MovieDetailsFeatureReducerComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        val dependencies = object : MovieDetailsFeatureReducerComponentDependencies {}
        _component = DaggerMovieDetailsFeatureReducerComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}
