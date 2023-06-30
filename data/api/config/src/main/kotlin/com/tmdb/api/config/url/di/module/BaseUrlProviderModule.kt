package com.tmdb.api.config.url.di.module

import com.tmdb.api.config.url.provider.base.BaseUrlProvider
import com.tmdb.api.config.url.provider.base.BaseUrlProviderImpl
import dagger.Module
import dagger.Provides

@Module
object BaseUrlProviderModule {
    @Provides
    fun baseUrlProvider(impl: BaseUrlProviderImpl): BaseUrlProvider = impl
}
