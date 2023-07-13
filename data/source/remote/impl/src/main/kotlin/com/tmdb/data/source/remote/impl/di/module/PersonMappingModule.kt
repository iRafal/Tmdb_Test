package com.tmdb.data.source.remote.impl.di.module

import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataModelMapper
import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.PersonListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.apiModelListToDataStateMapperImpl
import com.tmdb.data.source.remote.impl.mapping.apiModelToDataStateMapperImpl
import com.tmdb.data.source.remote.impl.mapping.personApiModelToDataModelMapperImpl
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
