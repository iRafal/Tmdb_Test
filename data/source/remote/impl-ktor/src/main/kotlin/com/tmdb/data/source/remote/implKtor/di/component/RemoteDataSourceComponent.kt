package com.tmdb.data.source.remote.implKtor.di.component

import com.tmdb.data.api.implKtor.di.component.ApiInjections
import com.tmdb.data.source.remote.implKtor.di.module.RemoteDataSourceModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [RemoteDataSourceModule::class], dependencies = [ApiInjections::class])
interface RemoteDataSourceComponent: RemoteDataSourceInjections {
    @Component.Builder
    interface Builder {
        fun apiInjections(dependencies: ApiInjections): Builder
        fun build(): RemoteDataSourceComponent
    }
}
