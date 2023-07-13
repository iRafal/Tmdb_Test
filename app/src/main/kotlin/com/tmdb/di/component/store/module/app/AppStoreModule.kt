package com.tmdb.di.component.store.module.app

import com.tmdb.di.component.store.module.env.AppEnvModule
import com.tmdb.di.component.store.module.reducer.AppReducerModule
import com.tmdb.store.app.AppStore
import com.tmdb.store.app.AppStoreImpl
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.reducer.app.AppReducer
import com.tmdb.store.state.app.AppState
import com.tmdb.utill.di.module.DispatchersModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import com.tmdb.utill.di.qualifiers.DispatcherIo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher


@Module(includes = [AppEnvModule::class, AppReducerModule::class, DispatchersModule::class])
object AppStoreModule {
    @[Provides ApplicationScope]
    fun appStore(
        appEnv: AppEnv,
        appReducer: @JvmSuppressWildcards AppReducer,
        @DispatcherIo dispatcher: CoroutineDispatcher,
    ): AppStore = AppStoreImpl(
        AppState.INITIAL,
        appEnv,
        appReducer,
        effectContext = dispatcher
    )
}
