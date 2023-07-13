package com.tmdb.data.source.remote.implKtor.mapping

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.api.model.data.DataPage
import com.tmdb.api.model.movie.Movie
import com.tmdb.api.model.util.ApiResponse
import com.tmdb.api.model.util.NetworkErrorModel
import com.tmdb.data.model.MovieDataModel
import com.tmdb.data.model.state.DataState

typealias MovieApiModelToDataStateModelMapper = (
    input: ApiResponse<Movie, NetworkErrorModel>
) -> DataState<MovieDataModel>

typealias MoviesListApiModelToDataStateModelMapper = (
    input: ApiResponse<DataPage<Movie>, NetworkErrorModel>
) -> DataState<List<MovieDataModel>>

typealias MovieApiModelToDataModelMapper = (input: Movie) -> MovieDataModel

fun movieApiToDataModelMapperImpl(imageUrlProvider: ImageUrlProvider): MovieApiModelToDataModelMapper = { input ->
    MovieDataModel(
        id = input.id,
        title = input.title,
        voteAverage = input.voteAverage,
        releaseDate = input.releaseDate,
        posterUrl = input.posterPath?.let { imageUrlProvider.posterUrl(it) }
    )
}
