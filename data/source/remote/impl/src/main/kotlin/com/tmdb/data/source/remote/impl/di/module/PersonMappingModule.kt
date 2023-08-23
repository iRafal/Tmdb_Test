package com.tmdb.data.source.remote.impl.di.module

import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataModelMapper
import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataModelMapperImpl
import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataStateModelMapperImpl
import com.tmdb.data.source.remote.impl.mapping.PersonListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.PersonListApiModelToDataStateModelMapperImpl
import dagger.Binds
import dagger.Module


@Module
interface PersonMappingModule {
    @Binds
    fun personApiModelToDataModelMapper(
        impl: PersonApiModelToDataModelMapperImpl
    ): PersonApiModelToDataModelMapper

    @Binds
    fun personApiModelToDataStateModelMapper(
        impl: PersonApiModelToDataStateModelMapperImpl
    ): PersonApiModelToDataStateModelMapper

    @Binds
    fun personListApiModelToDataStateModelMapper(
        impl: PersonListApiModelToDataStateModelMapperImpl
    ): PersonListApiModelToDataStateModelMapper
}

