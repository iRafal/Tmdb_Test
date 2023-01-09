package com.tmdb_test.ui.home.data.mapping

import com.tmdb_test.api.config.url.image.contract.ImageUrlProvider
import com.tmdb_test.data.model.MovieDataModel
import com.tmdb_test.ui.home.data.HomeUiData

typealias MovieDataToHomeModelMapper = (input: MovieDataModel) -> HomeUiData.Movie

fun movieDataToHomeModelMapperImpl(
    imageUrlProvider: ImageUrlProvider
): MovieDataToHomeModelMapper = { input ->
    HomeUiData.Movie(
        id = checkNotNull(input.id),
        title = checkNotNull(input.title),
        averageVote = input.voteAverage ?: 0.0,
        releaseDate = checkNotNull(input.releaseDate),
        posterUrl = input.posterPath?.let { imageUrlProvider.posterUrl(it) }
    )
}

typealias MovieDataItemsToHomeModelMapper = (input: List<MovieDataModel>) -> List<HomeUiData.Movie>

fun movieDataItemsToHomeModelMapperImpl(
    movieDataToHomeModelMapper: MovieDataToHomeModelMapper
): MovieDataItemsToHomeModelMapper = { input -> input.map { movieDataToHomeModelMapper(it) } }