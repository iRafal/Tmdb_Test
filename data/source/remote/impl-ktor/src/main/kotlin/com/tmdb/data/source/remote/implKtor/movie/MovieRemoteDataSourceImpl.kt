package com.tmdb.data.source.remote.implKtor.movie

import com.tmdb.data.api.implKtor.movie.MovieApi
import com.tmdb.data.model.MovieDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.implKtor.mapping.MovieApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.MoviesListApiModelToDataStateModelMapper
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi,
    private val movieApiModelToDataStateModelMapper: @JvmSuppressWildcards MovieApiModelToDataStateModelMapper,
    private val moviesListApiModelToDataStateModelMapper: @JvmSuppressWildcards MoviesListApiModelToDataStateModelMapper,
    ) : MovieRemoteDataSource {
    override suspend fun movie(
        movieId: Int,
        language: String?,
        appendToResponse: String?
    ): DataState<MovieDataModel> = movieApiModelToDataStateModelMapper(api.movie(movieId, language, appendToResponse))

    override suspend fun latestMovie(
        language: String?
    ): DataState<MovieDataModel> = movieApiModelToDataStateModelMapper(api.latestMovie(language))

    override suspend fun nowPlayingMovies(
        language: String?,
        page: Int?,
        region: String?
    ): DataState<List<MovieDataModel>> = moviesListApiModelToDataStateModelMapper(api.nowPlayingMovies(language, page, region))

    override suspend fun nowPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): DataState<List<MovieDataModel>> =
        moviesListApiModelToDataStateModelMapper(api.nowPopularMovies(language, page, region))

    override suspend fun topRatedMovies(
        language: String?,
        page: Int?,
        region: String?
    ): DataState<List<MovieDataModel>> = moviesListApiModelToDataStateModelMapper(api.topRatedMovies(language, page, region))

    override suspend fun upcomingMovies(
        language: String?,
        page: Int?,
        region: String?
    ): DataState<List<MovieDataModel>> = moviesListApiModelToDataStateModelMapper(api.upcomingMovies(language, page, region))
}
