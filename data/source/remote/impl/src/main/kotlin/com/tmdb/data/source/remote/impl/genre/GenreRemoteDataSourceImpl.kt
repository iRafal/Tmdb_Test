package com.tmdb.data.source.remote.impl.genre

import com.tmdb.api.implRetrofit.genre.GenreApi
import com.tmdb.data.model.GenreDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.impl.mapping.GenreListApiModelToDataStateModelMapper
import javax.inject.Inject

class GenreRemoteDataSourceImpl @Inject constructor(
    private val api: GenreApi,
    private val genreListApiModelToDataStateModelMapper: @JvmSuppressWildcards GenreListApiModelToDataStateModelMapper,
) : GenreRemoteDataSource {

    override suspend fun genreMovieList(language: String?): DataState<List<GenreDataModel>> {
        val response = api.genreMovieList(language)
        return genreListApiModelToDataStateModelMapper(response)
    }

    override suspend fun genreTvList(language: String?): DataState<List<GenreDataModel>> {
        val response = api.genreTvList(language)
        return genreListApiModelToDataStateModelMapper(response)
    }
}
