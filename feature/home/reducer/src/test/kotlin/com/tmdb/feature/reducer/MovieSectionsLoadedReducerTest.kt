package com.tmdb.feature.reducer

import com.tmdb.api.model.util.ApiException
import com.tmdb.data.model.MovieDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.feature.home.reducer.HomeFeatureEffects
import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.reducer.util.ModelUtil
import com.tmdb.store.action.HomeAction
import com.tmdb.store.base.Effects
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.state.AppState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class MovieSectionsLoadedReducerTest {

    private val testDispatcher: CoroutineDispatcher = Dispatchers.Unconfined

    @Test
    fun `reduce movie sections loaded success`() = runTest {
        val dataMovies = listOf(ModelUtil.movieDataModel)

        val dataSuccessMovies = DataState.Success(dataMovies)

        val action = HomeAction.MovieSectionsLoaded(
            nowPlayingMovies = dataSuccessMovies,
            nowPopularMovies = dataSuccessMovies,
            topRatedMovies = dataSuccessMovies,
            upcomingMovies = dataSuccessMovies
        )

        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)

        val appState = AppState.INITIAL.copy(
            homeState = AppState.INITIAL.homeState.copyAsAllLoading
        )

        val (homeFeatureState, effect) = homeFeatureSlice.reducer(appState, action)

        assertSame(effect, Effects.empty<AppEnv>())

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.movies?.isSuccess == true)
            assertTrue(nowPopularMovies.movies?.isSuccess == true)
            assertTrue(topRatedMovies.movies?.isSuccess == true)
            assertTrue(upcomingMovies.movies?.isSuccess == true)

            assertEquals(dataMovies, (nowPlayingMovies.movies as DataState.Success).data)
            assertEquals(dataMovies, (nowPopularMovies.movies as DataState.Success).data)
            assertEquals(dataMovies, (topRatedMovies.movies as DataState.Success).data)
            assertEquals(dataMovies, (upcomingMovies.movies as DataState.Success).data)
        }
    }

    @Test
    fun `reduce movie sections loaded network error`() = runTest {
        val expectedException = ApiException.NetworkError()
        val dataNetworkErrorMovies = DataState.NetworkError<List<MovieDataModel>>(expectedException)

        val action = HomeAction.MovieSectionsLoaded(
            nowPlayingMovies = dataNetworkErrorMovies,
            nowPopularMovies = dataNetworkErrorMovies,
            topRatedMovies = dataNetworkErrorMovies,
            upcomingMovies = dataNetworkErrorMovies
        )

        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)

        val appState = AppState.INITIAL.copy(homeState = AppState.INITIAL.homeState.copyAsAllLoading)
        val (homeFeatureState, effect) = homeFeatureSlice.reducer(appState, action)

        assertSame(effect, Effects.empty<AppEnv>())

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.movies?.isNetworkError == true)
            assertTrue(nowPopularMovies.movies?.isNetworkError == true)
            assertTrue(topRatedMovies.movies?.isNetworkError == true)
            assertTrue(upcomingMovies.movies?.isNetworkError == true)

            assertTrue((nowPlayingMovies.movies as DataState.NetworkError).cause is ApiException.NetworkError)
            assertTrue((nowPopularMovies.movies as DataState.NetworkError).cause is ApiException.NetworkError)
            assertTrue((topRatedMovies.movies as DataState.NetworkError).cause is ApiException.NetworkError)
            assertTrue((upcomingMovies.movies as DataState.NetworkError).cause is ApiException.NetworkError)
        }
    }

    @Test
    fun `reduce movie sections loaded api error`() = runTest {
        val dataApiErrorMovies = DataState.Error<List<MovieDataModel>>(ApiException.BadRequest())

        val appState = AppState.INITIAL.copy(homeState = AppState.INITIAL.homeState.copyAsAllLoading)

        val action = HomeAction.MovieSectionsLoaded(
            nowPlayingMovies = dataApiErrorMovies,
            nowPopularMovies = dataApiErrorMovies,
            topRatedMovies = dataApiErrorMovies,
            upcomingMovies = dataApiErrorMovies
        )

        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)

        val (homeFeatureState, effect) = homeFeatureSlice.reducer(appState, action)

        assertSame(effect, Effects.empty<AppEnv>())

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.movies?.isError == true)
            assertTrue(nowPopularMovies.movies?.isError == true)
            assertTrue(topRatedMovies.movies?.isError == true)
            assertTrue(upcomingMovies.movies?.isError == true)

            assertTrue((nowPlayingMovies.movies as DataState.Error).cause is ApiException.BadRequest)
            assertTrue((nowPopularMovies.movies as DataState.Error).cause is ApiException.BadRequest)
            assertTrue((topRatedMovies.movies as DataState.Error).cause is ApiException.BadRequest)
            assertTrue((upcomingMovies.movies as DataState.Error).cause is ApiException.BadRequest)
        }
    }

    @Test
    fun `reduce movie sections loaded unknown error`() = runTest {
        val dataUnknownErrorMovies = DataState.Error<List<MovieDataModel>>(ApiException.UnknownError())

        val appState = AppState.INITIAL.copy(homeState = AppState.INITIAL.homeState.copyAsAllLoading)

        val action = HomeAction.MovieSectionsLoaded(
            nowPlayingMovies = dataUnknownErrorMovies,
            nowPopularMovies = dataUnknownErrorMovies,
            topRatedMovies = dataUnknownErrorMovies,
            upcomingMovies = dataUnknownErrorMovies
        )

        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)

        val (homeFeatureState, effect) = homeFeatureSlice.reducer(appState, action)

        assertSame(effect, Effects.empty<AppEnv>())

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.movies?.isError == true)
            assertTrue(nowPopularMovies.movies?.isError == true)
            assertTrue(topRatedMovies.movies?.isError == true)
            assertTrue(upcomingMovies.movies?.isError == true)

            assertTrue((nowPlayingMovies.movies as DataState.Error).cause is ApiException.UnknownError)
            assertTrue((nowPopularMovies.movies as DataState.Error).cause is ApiException.UnknownError)
            assertTrue((topRatedMovies.movies as DataState.Error).cause is ApiException.UnknownError)
            assertTrue((upcomingMovies.movies as DataState.Error).cause is ApiException.UnknownError)
        }
    }
}
