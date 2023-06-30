package com.tmdb.feature.home.reducer.di.component

import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.home.reducer.di.module.HomeFeatureReducerModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(dependencies = [HomeFeatureReducerComponentDependencies::class], modules = [HomeFeatureReducerModule::class])]
interface HomeFeatureReducerComponent {

    val homeFeatureSlice: HomeFeatureSlice

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: HomeFeatureReducerComponentDependencies): Builder
        fun build(): HomeFeatureReducerComponent
    }
}
