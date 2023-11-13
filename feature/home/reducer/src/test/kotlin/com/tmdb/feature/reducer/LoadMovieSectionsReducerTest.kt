package com.tmdb.feature.reducer

import com.tmdb.api.model.util.ApiException
import com.tmdb.data.model.MovieDataModel
import com.tmdb.data.model.state.DataState
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import com.tmdb.data.source.remote.contract.discover.DiscoverRemoteDataSource
import com.tmdb.data.source.remote.contract.genre.GenreRemoteDataSource
import com.tmdb.data.source.remote.contract.movie.MovieRemoteDataSource
import com.tmdb.data.source.remote.contract.person.PersonRemoteDataSource
import com.tmdb.feature.home.reducer.HomeFeatureEffects
import com.tmdb.feature.home.reducer.HomeFeatureSlice
import com.tmdb.feature.reducer.util.ModelUtil
import com.tmdb.store.action.HomeAction
import com.tmdb.store.state.AppState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class LoadMovieSectionsReducerTest {

    private val discoverRemoteSource = mock<DiscoverRemoteDataSource>()
    private val genreRemoteSource = mock<GenreRemoteDataSource>()
    private val movieRemoteSource = mock<MovieRemoteDataSource>()
    private val personRemoteSource = mock<PersonRemoteDataSource>()
    private val movieLocalSource = mock<MovieLocalDataSource>()

    private val testDispatcher: CoroutineDispatcher = Dispatchers.Unconfined

    @Test
    fun `reduce load movie sections success`() = runTest {
        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)
        val appState = AppState.INITIAL
        val (homeFeatureState, effect) = homeFeatureSlice.reducer.map(appState, HomeAction.LoadMovieSections)

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.isLoading)
            assertTrue(nowPopularMovies.isLoading)
            assertTrue(topRatedMovies.isLoading)
            assertTrue(upcomingMovies.isLoading)
        }

        val movies = listOf(ModelUtil.movieDataModel)
        val dataSuccessMovies = DataState.Success(movies)
        with(movieRemoteSource) {
            whenever(nowPlayingMovies()).thenReturn(dataSuccessMovies)
            whenever(nowPopularMovies()).thenReturn(dataSuccessMovies)
            whenever(topRatedMovies()).thenReturn(dataSuccessMovies)
            whenever(upcomingMovies()).thenReturn(dataSuccessMovies)
        }

        val executor = createMockEffectExecutor(
            discoverRemoteSource,
            genreRemoteSource,
            movieRemoteSource,
            personRemoteSource,
            movieLocalSource
        )
        effect?.invoke(executor)

        with(movieRemoteSource) {
            verify(this, times(1)).nowPlayingMovies()
            verify(this, times(1)).nowPopularMovies()
            verify(this, times(1)).topRatedMovies()
            verify(this, times(1)).upcomingMovies()
        }

        verify(executor.effectExecutorScope).dispatch(
            HomeAction.MovieSectionsLoaded(
                nowPlayingMovies = dataSuccessMovies,
                nowPopularMovies = dataSuccessMovies,
                topRatedMovies = dataSuccessMovies,
                upcomingMovies = dataSuccessMovies
            )
        )
    }

    @Test
    fun `reduce load movie sections api error`() = runTest {
        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)
        val appState = AppState.INITIAL
        val (homeFeatureState, effect) = homeFeatureSlice.reducer.map(appState, HomeAction.LoadMovieSections)

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.isLoading)
            assertTrue(nowPopularMovies.isLoading)
            assertTrue(topRatedMovies.isLoading)
            assertTrue(upcomingMovies.isLoading)
        }

        val dataErrorMovies = DataState.Error<List<MovieDataModel>>(ApiException.BadRequest())
        with(movieRemoteSource) {
            whenever(nowPlayingMovies()).thenReturn(dataErrorMovies)
            whenever(nowPopularMovies()).thenReturn(dataErrorMovies)
            whenever(topRatedMovies()).thenReturn(dataErrorMovies)
            whenever(upcomingMovies()).thenReturn(dataErrorMovies)
        }

        val executor = createMockEffectExecutor(
            discoverRemoteSource,
            genreRemoteSource,
            movieRemoteSource,
            personRemoteSource,
            movieLocalSource
        )
        effect?.invoke(executor)

        with(movieRemoteSource) {
            verify(this, times(1)).nowPlayingMovies()
            verify(this, times(1)).nowPopularMovies()
            verify(this, times(1)).topRatedMovies()
            verify(this, times(1)).upcomingMovies()
        }

        verify(executor.effectExecutorScope).dispatch(
            HomeAction.MovieSectionsLoaded(
                nowPlayingMovies = dataErrorMovies,
                nowPopularMovies = dataErrorMovies,
                topRatedMovies = dataErrorMovies,
                upcomingMovies = dataErrorMovies
            )
        )
    }

    @Test
    fun `reduce load movie sections network error`() = runTest {
        val dataErrorMovies = DataState.NetworkError<List<MovieDataModel>>(ApiException.NetworkError())
        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)
        val appState = AppState.INITIAL
        val (homeFeatureState, effect) = homeFeatureSlice.reducer.map(appState, HomeAction.LoadMovieSections)

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.isLoading)
            assertTrue(nowPopularMovies.isLoading)
            assertTrue(topRatedMovies.isLoading)
            assertTrue(upcomingMovies.isLoading)
        }

        with(movieRemoteSource) {
            whenever(nowPlayingMovies()).thenReturn(dataErrorMovies)
            whenever(nowPopularMovies()).thenReturn(dataErrorMovies)
            whenever(topRatedMovies()).thenReturn(dataErrorMovies)
            whenever(upcomingMovies()).thenReturn(dataErrorMovies)
        }

        val executor = createMockEffectExecutor(
            discoverRemoteSource,
            genreRemoteSource,
            movieRemoteSource,
            personRemoteSource,
            movieLocalSource
        )
        effect?.invoke(executor)

        with(movieRemoteSource) {
            verify(this, times(1)).nowPlayingMovies()
            verify(this, times(1)).nowPopularMovies()
            verify(this, times(1)).topRatedMovies()
            verify(this, times(1)).upcomingMovies()
        }

        verify(executor.effectExecutorScope).dispatch(
            HomeAction.MovieSectionsLoaded(
                nowPlayingMovies = dataErrorMovies,
                nowPopularMovies = dataErrorMovies,
                topRatedMovies = dataErrorMovies,
                upcomingMovies = dataErrorMovies
            )
        )
    }

    @Test
    fun `reduce load movie sections unknown error`() = runTest {
        val dataErrorMovies = DataState.Error<List<MovieDataModel>>(ApiException.UnknownError())
        val homeFeatureEffects = HomeFeatureEffects(testDispatcher)
        val homeFeatureSlice = HomeFeatureSlice(homeFeatureEffects)
        val appState = AppState.INITIAL
        val (homeFeatureState, effect) = homeFeatureSlice.reducer.map(appState, HomeAction.LoadMovieSections)

        with(homeFeatureState) {
            assertTrue(nowPlayingMovies.isLoading)
            assertTrue(nowPopularMovies.isLoading)
            assertTrue(topRatedMovies.isLoading)
            assertTrue(upcomingMovies.isLoading)
        }

        with(movieRemoteSource) {
            whenever(nowPlayingMovies()).thenReturn(dataErrorMovies)
            whenever(nowPopularMovies()).thenReturn(dataErrorMovies)
            whenever(topRatedMovies()).thenReturn(dataErrorMovies)
            whenever(upcomingMovies()).thenReturn(dataErrorMovies)
        }

        val executor = createMockEffectExecutor(
            discoverRemoteSource,
            genreRemoteSource,
            movieRemoteSource,
            personRemoteSource,
            movieLocalSource
        )
        effect?.invoke(executor)

        with(movieRemoteSource) {
            verify(this, times(1)).nowPlayingMovies()
            verify(this, times(1)).nowPopularMovies()
            verify(this, times(1)).topRatedMovies()
            verify(this, times(1)).upcomingMovies()
        }

        verify(executor.effectExecutorScope).dispatch(
            HomeAction.MovieSectionsLoaded(
                nowPlayingMovies = dataErrorMovies,
                nowPopularMovies = dataErrorMovies,
                topRatedMovies = dataErrorMovies,
                upcomingMovies = dataErrorMovies
            )
        )
    }
}
