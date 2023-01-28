package com.tmdb_test.ui.home.data.mapping.di

import com.tmdb_test.ui.home.data.mapping.HomeFeatureStateToUiSectionStateMapper
import com.tmdb_test.ui.home.data.mapping.HomeFeatureToUiStateMapper
import com.tmdb_test.ui.home.data.mapping.HomeMovieSectionToActionMapper
import com.tmdb_test.ui.home.data.mapping.MovieDataItemsToHomeModelMapper
import com.tmdb_test.ui.home.data.mapping.MovieDataToHomeModelMapper
import com.tmdb_test.ui.home.data.mapping.homeFeatureToUiStateMapperImpl
import com.tmdb_test.ui.home.data.mapping.homeMovieSectionToActionMapperImpl
import com.tmdb_test.ui.home.data.mapping.movieDataItemsToHomeModelMapperImpl
import com.tmdb_test.ui.home.data.mapping.movieDataToHomeModelMapperImpl
import com.tmdb_test.ui.core.data.mapping.mapFeatureToUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeUiDataMappingModule {
    @Provides
    fun homeFeatureToUiStateMapper(
        homeFeatureStateToUiSectionStateMapper: @JvmSuppressWildcards HomeFeatureStateToUiSectionStateMapper,
    ): @JvmSuppressWildcards HomeFeatureToUiStateMapper =
        homeFeatureToUiStateMapperImpl(homeFeatureStateToUiSectionStateMapper)

    @Provides
    fun homeFeatureStateToUiSectionStateMapper(
        movieDataItemsToHomeModelMapper: @JvmSuppressWildcards MovieDataItemsToHomeModelMapper
    ): @JvmSuppressWildcards HomeFeatureStateToUiSectionStateMapper =
        mapFeatureToUiState(movieDataItemsToHomeModelMapper)

    @Provides
    fun movieDataItemsToHomeModelMapper(
        movieDataToHomeModelMapper: @JvmSuppressWildcards MovieDataToHomeModelMapper
    ): @JvmSuppressWildcards MovieDataItemsToHomeModelMapper =
        movieDataItemsToHomeModelMapperImpl(movieDataToHomeModelMapper)

    @Provides
    fun movieDataToHomeModelMapper(
    ): @JvmSuppressWildcards MovieDataToHomeModelMapper = movieDataToHomeModelMapperImpl()

    @Provides
    fun homeMovieSectionToActionMapper(
    ): @JvmSuppressWildcards HomeMovieSectionToActionMapper = ::homeMovieSectionToActionMapperImpl
}