package com.tmdb.data.source.remote.impl.mapping

import com.tmdb.api.model.data.DataPage
import com.tmdb.api.model.person.Person
import com.tmdb.api.model.util.ApiResponse
import com.tmdb.api.model.util.NetworkErrorModel
import com.tmdb.data.model.PersonDataModel
import com.tmdb.data.model.state.DataState

typealias PersonApiModelToDataStateModelMapper = (
    input: ApiResponse<Person, NetworkErrorModel>
) -> DataState<PersonDataModel>

typealias PersonListApiModelToDataStateModelMapper = (
    input: ApiResponse<DataPage<Person>, NetworkErrorModel>
) -> DataState<List<PersonDataModel>>

typealias PersonApiModelToDataModelMapper = (input: Person) -> PersonDataModel

fun personApiModelToDataModelMapperImpl(): PersonApiModelToDataModelMapper = { input ->
    //TODO
    PersonDataModel()
}
