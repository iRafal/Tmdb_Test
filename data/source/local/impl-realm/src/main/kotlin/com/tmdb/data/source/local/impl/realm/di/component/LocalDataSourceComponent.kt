package com.tmdb.data.source.local.impl.realm.di.component

import android.content.Context
import com.tmdb.data.db.realm.di.modules.DbModule
import com.tmdb.data.source.local.impl.realm.di.module.LocalDataSourceModule
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.BindsInstance
import dagger.Component


@[ApplicationScope Component(modules = [LocalDataSourceModule::class, DbModule::class])]
interface LocalDataSourceComponent: LocalDataSourceInjections {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(@ApplicationContext dependency: Context): Builder
        fun build(): LocalDataSourceComponent
    }
}
