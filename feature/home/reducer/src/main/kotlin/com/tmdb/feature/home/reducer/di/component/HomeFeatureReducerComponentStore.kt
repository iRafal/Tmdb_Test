package com.tmdb.feature.home.reducer.di.component

import com.tmdb.data.model.mapping.di.component.DataModelMappingComponentStore
import com.tmdb.data.model.mapping.movie.MoviesApiToDataStateMapper

object HomeFeatureReducerComponentStore {
    private var _component: HomeFeatureReducerComponent? = null
    val component: HomeFeatureReducerComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        DataModelMappingComponentStore.init()

        val dependencies = object : HomeFeatureReducerComponentDependencies {
            override val moviesApiToDataStateMapper: MoviesApiToDataStateMapper
                get() = DataModelMappingComponentStore.component.moviesApiToDataStateMapper
        }
        _component = DaggerHomeFeatureReducerComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}
