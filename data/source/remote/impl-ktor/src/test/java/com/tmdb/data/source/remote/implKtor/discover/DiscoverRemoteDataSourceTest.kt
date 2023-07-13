package com.tmdb.data.source.remote.implKtor.discover

import com.tmdb.api.model.data.DataPage
import com.tmdb.api.model.movie.Movie
import com.tmdb.api.model.util.ApiException
import com.tmdb.api.model.util.ApiResponse
import com.tmdb.api.model.util.NetworkErrorModel
import com.tmdb.data.api.implKtor.discover.DiscoverApi
import com.tmdb.data.model.MovieDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.implKtor.mapping.MoviesListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.util.model.ApiErrorImpl
import com.tmdb.data.source.remote.implKtor.util.model.ModelUtil
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class DiscoverRemoteDataSourceTest {
    private val discoverApi = mock<DiscoverApi>()
    private val moviesListApiModelToDataStateModelMapper: MoviesListApiModelToDataStateModelMapper = mock()
    private val discoverSource: DiscoverRemoteDataSource = DiscoverRemoteDataSourceImpl(discoverApi, moviesListApiModelToDataStateModelMapper)

    private val expectedNetworkException = ApiException.NetworkError(message = "Network error")
    private val expectedNetworkErrorApiResponse = ApiResponse.NetworkError(expectedNetworkException)

    private val expectedErrorBody = ApiErrorImpl()
    private val expectedErrorCode = 500
    private val expectedApiErrorException = Throwable("Body: [${expectedErrorBody}], code=${expectedErrorCode}")
    private val expectedApiErrorResponse = ApiResponse.ApiError(expectedErrorBody, expectedErrorCode)

    private val expectedUnknownException = Throwable("Unknown Exception")
    private val expectedUnknownErrorResponse = ApiResponse.UnknownError(expectedUnknownException)

    @Test
    fun `discover movie list success`() = runTest {
        val expectedApiResponse = ApiResponse.Success(
            DataPage(
                page = 1,
                results = listOf(ModelUtil.movieModel),
                totalPages = 1,
                totalResults = 1
            )
        )
        val expectedDataState = DataState.Success(listOf(ModelUtil.movieDataModel))

        whenever(moviesListApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverMovie()).thenReturn(expectedApiResponse)

        discoverSource.discoverMovie().run {
            assertTrue(this.isSuccess)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverMovie()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover movie list network error`() = runTest {
        val expectedException = expectedNetworkException
        val expectedDataState: DataState<List<MovieDataModel>> = DataState.NetworkError(expectedException)
        val expectedApiResponse = expectedNetworkErrorApiResponse

        whenever(moviesListApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverMovie()).thenReturn(expectedApiResponse)

        discoverSource.discoverMovie().run {
            assertTrue(this.isNetworkError)
            assertSame(expectedDataState, this)
        }
        verify(discoverApi, times(1)).discoverMovie()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover movie list api error`() = runTest {
        val expectedException = expectedApiErrorException
        val expectedDataState: DataState<List<MovieDataModel>> = DataState.Error(expectedException)
        val expectedApiResponse: ApiResponse<DataPage<Movie>, NetworkErrorModel> = expectedApiErrorResponse

        whenever(moviesListApiModelToDataStateModelMapper(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverMovie()).thenReturn(expectedApiResponse)

        discoverSource.discoverMovie().run {
            assertTrue(this.isError)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverMovie()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover movie list unknown error`() = runTest {
        val expectedException = expectedUnknownException
        val expectedDataState: DataState<List<MovieDataModel>> = DataState.Error(expectedException)
        val expectedApiResponse: ApiResponse<DataPage<Movie>, NetworkErrorModel> = expectedUnknownErrorResponse

        whenever(moviesListApiModelToDataStateModelMapper(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverMovie()).thenReturn(expectedApiResponse)

        discoverSource.discoverMovie().run {
            assertTrue(this.isError)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverMovie()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover tv list success`() = runTest {
        val expectedApiResponse = ApiResponse.Success(
            DataPage(
                page = 1,
                results = listOf(ModelUtil.movieModel),
                totalPages = 1,
                totalResults = 1
            )
        )
        val expectedDataState = DataState.Success(listOf(ModelUtil.movieDataModel))

        whenever(discoverApi.discoverTv()).thenReturn(expectedApiResponse)
        whenever(moviesListApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)

        discoverSource.discoverTv().run {
            assertTrue(this.isSuccess)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverTv()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover tv list network error`() = runTest {
        val expectedException = expectedNetworkException
        val expectedDataState: DataState<List<MovieDataModel>> = DataState.NetworkError(expectedException)
        val expectedApiResponse = expectedNetworkErrorApiResponse

        whenever(moviesListApiModelToDataStateModelMapper.invoke(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverTv()).thenReturn(expectedApiResponse)

        discoverSource.discoverTv().run {
            assertTrue(this.isNetworkError)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverTv()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover tv list api error`() = runTest {
        val expectedException = expectedApiErrorException
        val expectedDataState: DataState<List<MovieDataModel>> = DataState.Error(expectedException)
        val expectedApiResponse: ApiResponse<DataPage<Movie>, NetworkErrorModel> = expectedApiErrorResponse

        whenever(moviesListApiModelToDataStateModelMapper(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverTv()).thenReturn(expectedApiResponse)

        discoverSource.discoverTv().run {
            assertTrue(this.isError)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverTv()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }

    @Test
    fun `discover tv list unknown error`() = runTest {
        val expectedException = expectedUnknownException
        val expectedDataState: DataState<List<MovieDataModel>> = DataState.Error(expectedException)
        val expectedApiResponse: ApiResponse<DataPage<Movie>, NetworkErrorModel> = expectedUnknownErrorResponse

        whenever(moviesListApiModelToDataStateModelMapper(expectedApiResponse)).thenReturn(expectedDataState)
        whenever(discoverApi.discoverTv()).thenReturn(expectedApiResponse)

        discoverSource.discoverTv().run {
            assertTrue(this.isError)
            assertSame(expectedDataState, this)
        }

        verify(discoverApi, times(1)).discoverTv()
        verify(moviesListApiModelToDataStateModelMapper, times(1)).invoke(expectedApiResponse)
    }
}
