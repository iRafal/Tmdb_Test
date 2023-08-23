package com.tmdb.store.di.module.app

import com.tmdb.store.AppReducer
import com.tmdb.store.AppStore
import com.tmdb.store.di.module.env.AppEnvModule
import com.tmdb.store.di.module.reducer.AppReducerModule
import com.tmdb.store.env.contract.AppEnv
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
    ): AppStore = AppStore.create(
        appReducer,
        appEnv,
        effectContext = dispatcher
    )
}
