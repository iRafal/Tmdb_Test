package com.tmdb.store.env.di.component

import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.env.di.module.AppEnvModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(dependencies = [AppEnvComponentDependencies::class], modules = [AppEnvModule::class])]
interface AppEnvComponent {

    val appEnv: AppEnv

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: AppEnvComponentDependencies): Builder
        fun build(): AppEnvComponent
    }
}