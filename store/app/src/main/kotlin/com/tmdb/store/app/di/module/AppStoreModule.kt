package com.tmdb.store.app.di.module

import com.tmdb.store.app.AppStore
import com.tmdb.store.app.AppStoreImpl
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.reducer.app.AppReducer
import com.tmdb.store.state.app.AppState
import com.tmdb.store.state.di.module.StoreStateModule
import com.tmdb.store.state.di.module.StoreStateModule.InitialAppState
import com.tmdb.utill.di.module.DispatchersModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import com.tmdb.utill.di.qualifiers.DispatcherIo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher


@Module(includes = [StoreStateModule::class, DispatchersModule::class])
object AppStoreModule {
    @[Provides ApplicationScope]
    fun appStore(
        appEnv: AppEnv,
        appReducer: @JvmSuppressWildcards AppReducer,
        @DispatcherIo dispatcher: CoroutineDispatcher,
        @InitialAppState appState: AppState
    ): AppStore = AppStoreImpl(
        appState,
        appEnv,
        appReducer,
        effectContext = dispatcher
    )
}
