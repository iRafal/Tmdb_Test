package com.tmdb.data.source.remote.impl.person

import com.tmdb.api.implRetrofit.person.PersonApi
import com.tmdb.data.model.PersonDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource
import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataStateModelMapper
import javax.inject.Inject

class PersonRemoteDataSourceImpl @Inject constructor(
    private val api: PersonApi,
    private val personApiModelToDataStateModelMapper: @JvmSuppressWildcards PersonApiModelToDataStateModelMapper
) : PersonRemoteDataSource {
    override suspend fun personDetails(
        personId: Int,
        language: String?,
        appendToResponse: String?
    ): DataState<PersonDataModel> = personApiModelToDataStateModelMapper(api.personDetails(personId, language, appendToResponse))
}
