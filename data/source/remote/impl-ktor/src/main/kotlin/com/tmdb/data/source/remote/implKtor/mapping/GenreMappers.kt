package com.tmdb.data.source.remote.implKtor.mapping

import com.tmdb.api.model.genre.Genre
import com.tmdb.api.model.genre.GenresList
import com.tmdb.api.model.util.ApiResponse
import com.tmdb.api.model.util.NetworkErrorModel
import com.tmdb.data.model.GenreDataModel
import com.tmdb.data.model.state.DataState

typealias GenreApiModelToDataStateModelMapper = (
    input: ApiResponse<Genre, NetworkErrorModel>
) -> DataState<GenreDataModel>

typealias GenreListApiModelToDataStateModelMapper = (
    input: ApiResponse<GenresList, NetworkErrorModel>
) -> DataState<List<GenreDataModel>>

internal fun genreListToDataStateMapperImpl(
    genreApiModelToDataModelMapper: GenreApiModelToDataModelMapper
) = { input: ApiResponse<GenresList, NetworkErrorModel> ->
    val dataMapper: (GenresList) -> List<GenreDataModel> = { genreList ->
        genreList.genres.map(genreApiModelToDataModelMapper)
    }
    input.mapApiStateToDataState(dataMapper)
}

typealias GenreApiModelToDataModelMapper = (input: Genre) -> GenreDataModel

fun genreApiModelToDataModelMapperImpl(): GenreApiModelToDataModelMapper = { input ->
    //TODO
    GenreDataModel()
}

