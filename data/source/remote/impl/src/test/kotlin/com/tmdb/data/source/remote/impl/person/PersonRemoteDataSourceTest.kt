package com.tmdb.data.source.remote.impl.person

import com.tmdb.api.implRetrofit.person.PersonApi
import com.tmdb.api.model.person.Person
import com.tmdb.api.model.util.ApiException
import com.tmdb.api.model.util.ApiResponse
import com.tmdb.api.model.util.NetworkErrorModel
import com.tmdb.data.model.PersonDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource
import com.tmdb.data.source.remote.impl.mapping.PersonApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.util.model.ApiErrorImpl
import com.tmdb.data.source.remote.impl.util.model.ModelUtil
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


class PersonRemoteDataSourceTest {
    private val personApi = mock<PersonApi>()
    private val personApiModelToDataStateModelMapper: PersonApiModelToDataStateModelMapper = mock()
    private val personSource: PersonRemoteDataSource = PersonRemoteDataSourceImpl(personApi, personApiModelToDataStateModelMapper)

    private val expectedNetworkException = ApiException.NetworkError(message = "Network error")
    private val expectedNetworkErrorApiResponse = ApiResponse.NetworkError(expectedNetworkException)

    private val expectedErrorBody = ApiErrorImpl()
    private val expectedErrorCode = 500
    private val expectedApiErrorException = Throwable("Body: [${expectedErrorBody}], code=${expectedErrorCode}")
    private val expectedApiErrorResponse = ApiResponse.ApiError(expectedErrorBody, expectedErrorCode)

    private val expectedUnknownException = Throwable("Unknown Exception")
    private val expectedUnknownErrorResponse = ApiResponse.UnknownError(expectedUnknownException)

    private val expectedPersonId = 287

    @Test
    fun `person details success`() = runTest {
        val expectedApiResponse = ApiResponse.Success(ModelUtil.personModel)
        val expectedDataState = DataState.Success(ModelUtil.personDataModel)

        whenever(personApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(personApi.personDetails(expectedPersonId)).thenReturn(expectedApiResponse)

        personSource.personDetails(expectedPersonId).run {
            assertTrue(this.isSuccess)
            assertSame(expectedDataState, this)
        }

        verify(personApi, times(1)).personDetails(expectedPersonId)
        verify(personApiModelToDataStateModelMapper, Mockito.times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `person details network error`() = runTest {
        val expectedException = expectedNetworkException
        val expectedDataState: DataState<PersonDataModel> = DataState.NetworkError(expectedException)
        val expectedApiResponse = expectedNetworkErrorApiResponse

        whenever(personApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(personApi.personDetails(expectedPersonId)).thenReturn(expectedApiResponse)

        personSource.personDetails(expectedPersonId).run {
            assertTrue(this.isNetworkError)
            assertSame(expectedDataState, this)
        }

        verify(personApi, times(1)).personDetails(expectedPersonId)
        verify(personApiModelToDataStateModelMapper, Mockito.times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `person details api error`() = runTest {
        val expectedException = expectedApiErrorException
        val expectedDataState: DataState<PersonDataModel> = DataState.Error(expectedException)
        val expectedApiResponse: ApiResponse<Person, NetworkErrorModel> = expectedApiErrorResponse

        whenever(personApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(personApi.personDetails(expectedPersonId)).thenReturn(expectedApiResponse)

        personSource.personDetails(expectedPersonId).run {
            assertTrue(this.isError)
            assertSame(expectedDataState, this)
        }

        verify(personApi, times(1)).personDetails(expectedPersonId)
        verify(personApiModelToDataStateModelMapper, Mockito.times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `person details unknown error`() = runTest {
        val expectedException = expectedUnknownException
        val expectedDataState: DataState<PersonDataModel> = DataState.Error(expectedException)
        val expectedApiResponse: ApiResponse<Person, NetworkErrorModel> = expectedUnknownErrorResponse

        whenever(personApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(personApi.personDetails(expectedPersonId)).thenReturn(expectedApiResponse)

        personSource.personDetails(expectedPersonId).run {
            assertTrue(this.isError)
            assertSame(expectedDataState, this)
        }

        verify(personApi, times(1)).personDetails(expectedPersonId)
        verify(personApiModelToDataStateModelMapper, Mockito.times(1)).invoke(expectedApiResponse)
    }
}
