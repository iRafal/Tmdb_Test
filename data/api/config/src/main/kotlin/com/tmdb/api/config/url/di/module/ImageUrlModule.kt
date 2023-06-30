package com.tmdb.api.config.url.di.module

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.api.config.url.image.impl.ImageUrlProviderImpl
import com.tmdb.api.config.url.provider.base.BaseUrlProvider
import dagger.Module
import dagger.Provides

@Module
object ImageUrlModule {

    @Provides
    fun imageUrlProvider(baseUrlProvider: BaseUrlProvider): ImageUrlProvider =
        ImageUrlProviderImpl(baseUrlProvider.apiImageUrl)
}
