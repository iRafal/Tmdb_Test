package com.tmdb.data.source.remote.implKtor.di.module

import com.tmdb.data.source.remote.implKtor.mapping.GenreApiModelToDataModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.GenreApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.GenreListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.apiModelToDataStateMapperImpl
import com.tmdb.data.source.remote.implKtor.mapping.genreApiModelToDataModelMapperImpl
import com.tmdb.data.source.remote.implKtor.mapping.genreListToDataStateMapperImpl
import dagger.Module
import dagger.Provides


@Module
object GenreMappingModule {
    @Provides
    fun genreApiModelToDataModelMapper(
    ): @JvmSuppressWildcards GenreApiModelToDataModelMapper = genreApiModelToDataModelMapperImpl()

    @Provides
    fun genreApiModelToDataStateModelMapper(
        genreApiModelToDataModelMapper: @JvmSuppressWildcards GenreApiModelToDataModelMapper
    ): @JvmSuppressWildcards GenreApiModelToDataStateModelMapper = apiModelToDataStateMapperImpl(genreApiModelToDataModelMapper)

    @Provides
    fun genreListApiModelToDataStateModelMapper(
        genreApiModelToDataModelMapper: @JvmSuppressWildcards GenreApiModelToDataModelMapper
    ): @JvmSuppressWildcards GenreListApiModelToDataStateModelMapper {
        return genreListToDataStateMapperImpl(genreApiModelToDataModelMapper)
    }
}
