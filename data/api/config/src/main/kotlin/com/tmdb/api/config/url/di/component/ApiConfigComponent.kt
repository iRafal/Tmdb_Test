package com.tmdb.api.config.url.di.component

import com.tmdb.api.config.url.di.module.ImageUrlModule
import com.tmdb.api.config.url.di.module.UrlProviderModule
import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.api.config.url.provider.discover.DiscoverUrlProvider
import com.tmdb.api.config.url.provider.genre.GenreUrlProvider
import com.tmdb.api.config.url.provider.movie.MovieUrlProvider
import com.tmdb.api.config.url.provider.person.PersonUrlProvider
import dagger.Component

@[Component(modules = [ImageUrlModule::class, UrlProviderModule::class])]
interface ApiConfigComponent {

    val imageUrlProvider: ImageUrlProvider

    val discoverUrlProvider: DiscoverUrlProvider
    val genreUrlProvider: GenreUrlProvider
    val movieUrlProvider: MovieUrlProvider
    val personUrlProvider: PersonUrlProvider

    @Component.Builder
    interface Builder {
        fun build(): ApiConfigComponent
    }
}
