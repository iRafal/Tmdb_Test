package com.tmdb.data.source.local.impl.di.component

import android.content.Context
import com.tmdb.data.source.local.impl.di.module.LocalDataSourceModule
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(modules = [LocalDataSourceModule::class])
interface LocalDataSourceComponent: LocalDataSourceInjections {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(@ApplicationContext dependency: Context): Builder
        fun build(): LocalDataSourceComponent
    }
}
