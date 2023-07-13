package com.tmdb.data.source.remote.implKtor.di.module

import com.tmdb.data.source.remote.implKtor.mapping.PersonApiModelToDataModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.PersonApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.PersonListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.apiModelListToDataStateMapperImpl
import com.tmdb.data.source.remote.implKtor.mapping.apiModelToDataStateMapperImpl
import com.tmdb.data.source.remote.implKtor.mapping.personApiModelToDataModelMapperImpl
import dagger.Module
import dagger.Provides


@Module
object PersonMappingModule {
    @Provides
    fun personApiModelToDataModelMapper(
    ): @JvmSuppressWildcards PersonApiModelToDataModelMapper = personApiModelToDataModelMapperImpl()

    @Provides
    fun personApiModelToDataStateModelMapper(
        personApiModelToDataModelMapper: @JvmSuppressWildcards PersonApiModelToDataModelMapper
    ): @JvmSuppressWildcards PersonApiModelToDataStateModelMapper = apiModelToDataStateMapperImpl(personApiModelToDataModelMapper)

    @Provides
    fun personListApiModelToDataStateModelMapper(
        personApiModelToDataModelMapper: @JvmSuppressWildcards PersonApiModelToDataModelMapper
    ): @JvmSuppressWildcards PersonListApiModelToDataStateModelMapper {
        return apiModelListToDataStateMapperImpl(personApiModelToDataModelMapper)
    }
}
