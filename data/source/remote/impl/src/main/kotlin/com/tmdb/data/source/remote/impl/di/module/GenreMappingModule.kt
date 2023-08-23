package com.tmdb.data.source.remote.impl.di.module

import com.tmdb.data.source.remote.impl.mapping.GenreApiModelToDataModelMapper
import com.tmdb.data.source.remote.impl.mapping.GenreApiModelToDataModelMapperImpl
import com.tmdb.data.source.remote.impl.mapping.GenreApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.GenreApiModelToDataStateModelMapperImpl
import com.tmdb.data.source.remote.impl.mapping.GenreListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.GenreListApiModelToDataStateModelMapperImpl
import dagger.Binds
import dagger.Module


@Module
interface GenreMappingModule {
    @Binds
    fun genreApiModelToDataModelMapper(
        impl: GenreApiModelToDataModelMapperImpl
    ): GenreApiModelToDataModelMapper

    @Binds
    fun genreApiModelToDataStateModelMapper(
        impl: GenreApiModelToDataStateModelMapperImpl
    ): GenreApiModelToDataStateModelMapper

    @Binds
    fun genreListApiModelToDataStateModelMapper(
        impl: GenreListApiModelToDataStateModelMapperImpl
    ): GenreListApiModelToDataStateModelMapper
}
