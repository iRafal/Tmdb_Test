package com.tmdb.feature.home.ui.di.module

import com.tmdb.feature.home.ui.data.mapping.HomeDataStateToUiStateMapper
import com.tmdb.feature.home.ui.data.mapping.HomeFeatureStateToUiStateMapper
import com.tmdb.feature.home.ui.data.mapping.HomeMovieSectionToActionMapper
import com.tmdb.feature.home.ui.data.mapping.MovieDataItemsToHomeModelMapper
import com.tmdb.feature.home.ui.data.mapping.MovieDataToHomeModelMapper
import com.tmdb.feature.home.ui.data.mapping.homeFeatureToUiStateMapperImpl
import com.tmdb.feature.home.ui.data.mapping.homeMovieSectionToActionMapperImpl
import com.tmdb.feature.home.ui.data.mapping.movieDataItemsToHomeModelMapperImpl
import com.tmdb.feature.home.ui.data.mapping.movieDataToHomeModelMapperImpl
import com.tmdb.ui.core.data.mapping.mapDataStateToUiState
import dagger.Module
import dagger.Provides


@Module
object HomeUiDataMappingModule {
    @Provides
    fun homeFeatureToUiStateMapper(
        homeDataStateToUiStateMapper: @JvmSuppressWildcards HomeDataStateToUiStateMapper
    ): @JvmSuppressWildcards HomeFeatureStateToUiStateMapper =
        homeFeatureToUiStateMapperImpl(homeDataStateToUiStateMapper)

    @Provides
    fun homeFeatureStateToUiSectionStateMapper(
        movieDataItemsToHomeModelMapper: @JvmSuppressWildcards MovieDataItemsToHomeModelMapper
    ): @JvmSuppressWildcards HomeDataStateToUiStateMapper =
        mapDataStateToUiState(movieDataItemsToHomeModelMapper)

    @Provides
    fun movieDataItemsToHomeModelMapper(
        movieDataToHomeModelMapper: @JvmSuppressWildcards MovieDataToHomeModelMapper
    ): @JvmSuppressWildcards MovieDataItemsToHomeModelMapper =
        movieDataItemsToHomeModelMapperImpl(movieDataToHomeModelMapper)

    @Provides
    fun movieDataToHomeModelMapper(): @JvmSuppressWildcards MovieDataToHomeModelMapper = movieDataToHomeModelMapperImpl()

    @Provides
    fun homeMovieSectionToActionMapper(): @JvmSuppressWildcards HomeMovieSectionToActionMapper = ::homeMovieSectionToActionMapperImpl
}
