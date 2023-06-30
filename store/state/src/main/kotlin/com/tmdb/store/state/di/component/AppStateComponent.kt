package com.tmdb.store.state.di.component

import com.tmdb.store.state.app.AppState
import com.tmdb.store.state.di.module.HomeFeatureMappingModule
import com.tmdb.store.state.di.module.StoreStateModule
import com.tmdb.store.state.di.module.StoreStateModule.InitialAppState
import com.tmdb.store.state.home.MoviesDataToFeatureStateMapper
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(modules = [StoreStateModule::class, HomeFeatureMappingModule::class])]
interface AppStateComponent {

    @get:[ApplicationScope InitialAppState]
    val initialAppState: AppState

    val moviesDataToFeatureStateMapper: @JvmSuppressWildcards MoviesDataToFeatureStateMapper

    @Component.Builder
    interface Builder {
        fun build(): AppStateComponent
    }
}
