package com.tmdb.store.reducer.app.di.component

import com.tmdb.store.reducer.app.AppReducer
import com.tmdb.store.reducer.app.di.module.AppReducerModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(dependencies = [AppReducerComponentDependencies::class], modules = [AppReducerModule::class])]
interface AppReducerComponent {

    val appReducer: AppReducer

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: AppReducerComponentDependencies): Builder
        fun build(): AppReducerComponent
    }
}
