package com.tmdb.store.state.di.module

import com.tmdb.store.state.app.AppState
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier


@Module
object StoreStateModule {

    @[Qualifier Retention(AnnotationRetention.BINARY)]
    annotation class InitialAppState

    @[Provides ApplicationScope InitialAppState]
    fun initialAppState(): AppState = AppState.INITIAL
}
