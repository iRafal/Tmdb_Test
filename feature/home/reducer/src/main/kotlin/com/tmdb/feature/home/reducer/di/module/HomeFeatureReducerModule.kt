package com.tmdb.feature.home.reducer.di.module

import com.tmdb.data.model.mapping.movie.MoviesApiToDataStateMapper
import com.tmdb.feature.home.reducer.HomeFeatureEffects
import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.home.reducer.HomeFeatureSliceImpl
import com.tmdb.store.state.di.module.HomeFeatureMappingModule
import com.tmdb.store.state.home.MoviesDataToFeatureStateMapper
import com.tmdb.utill.di.module.DispatchersModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import com.tmdb.utill.di.qualifiers.DispatcherIo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module(includes = [HomeFeatureMappingModule::class, DispatchersModule::class])
object HomeFeatureReducerModule {

    @Provides
    fun homeFeatureSlice(
        moviesApiToDataStateMapper: @JvmSuppressWildcards MoviesApiToDataStateMapper,
        moviesDataToFeatureStateMapper: @JvmSuppressWildcards MoviesDataToFeatureStateMapper,
        homeFeatureEffects: HomeFeatureEffects
    ): HomeFeatureSlice = HomeFeatureSliceImpl(
        moviesApiToDataStateMapper,
        moviesDataToFeatureStateMapper,
        homeFeatureEffects
    )

    @[Provides ApplicationScope]
    fun homeFeatureEffects(
        @DispatcherIo dispatcher: CoroutineDispatcher
    ) = HomeFeatureEffects(dispatcher)
}