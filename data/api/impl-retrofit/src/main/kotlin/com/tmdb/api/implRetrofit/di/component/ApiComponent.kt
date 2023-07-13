package com.tmdb.api.implRetrofit.di.component

import com.tmdb.api.config.url.di.module.ApiConfigModule
import com.tmdb.api.implRetrofit.di.module.ApiModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component


@[ApplicationScope Component(modules = [ApiModule::class, ApiConfigModule::class])]
interface ApiComponent: ApiInjections {

    @Component.Builder
    interface Builder {
        fun build(): ApiComponent
    }
}
