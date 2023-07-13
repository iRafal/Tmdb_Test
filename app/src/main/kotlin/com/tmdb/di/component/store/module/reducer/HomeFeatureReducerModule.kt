package com.tmdb.di.component.store.module.reducer

import com.tmdb.feature.home.reducer.HomeFeatureEffects
import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.home.reducer.HomeFeatureSliceImpl
import com.tmdb.utill.di.module.DispatchersModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import com.tmdb.utill.di.qualifiers.DispatcherIo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module(includes = [DispatchersModule::class])
object HomeFeatureReducerModule {

    @Provides
    fun homeFeatureSlice(
        homeFeatureEffects: HomeFeatureEffects
    ): HomeFeatureSlice = HomeFeatureSliceImpl(homeFeatureEffects)

    @[Provides ApplicationScope]
    fun homeFeatureEffects(@DispatcherIo dispatcher: CoroutineDispatcher) = HomeFeatureEffects(dispatcher)
}
