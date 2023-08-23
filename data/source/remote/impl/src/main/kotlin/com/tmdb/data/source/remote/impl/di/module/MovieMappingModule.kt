package com.tmdb.data.source.remote.impl.di.module


import com.tmdb.data.source.remote.impl.mapping.MovieApiModelToDataModelMapper
import com.tmdb.data.source.remote.impl.mapping.MovieApiModelToDataModelMapperImpl
import com.tmdb.data.source.remote.impl.mapping.MovieApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.MovieApiModelToDataStateModelMapperImpl
import com.tmdb.data.source.remote.impl.mapping.MoviesListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.MoviesListApiModelToDataStateModelMapperImpl
import dagger.Binds
import dagger.Module

@Module
interface MovieMappingModule {
    @Binds
    fun movieApiToDataModelMapper(
        impl: MovieApiModelToDataModelMapperImpl
    ): MovieApiModelToDataModelMapper

    @Binds
    fun movieApiModelToDataStateModelMapper(
        impl: MovieApiModelToDataStateModelMapperImpl
    ): MovieApiModelToDataStateModelMapper

    @Binds
    fun moviesApiToDataStateMapper(
        impl: MoviesListApiModelToDataStateModelMapperImpl
    ): MoviesListApiModelToDataStateModelMapper
}
