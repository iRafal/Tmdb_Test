package com.tmdb.api.config.url.di.module

import dagger.Module

@Module(includes = [ImageUrlModule::class, UrlProviderModule::class])
object ApiConfigModule
