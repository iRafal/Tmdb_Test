package com.tmdb_test.feature.movie.details.content

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tmdb_test.feature.movie.details.content.MovieDetailsUiEvent.NavigateBack
import com.tmdb_test.feature.movie.details.content.MovieDetailsUiState.Loading
import com.tmdb_test.ui.app.navigation.AppNavigation
import com.tmdb_test.ui.theme.Tmdb_TestTheme

@Composable
fun MovieDetailsRoute(
    navController: NavController,
    movieDetailsViewModel: MovieDetailsViewModel,
    movieId: Int
) {
    Tmdb_TestTheme {
        val state = Loading
//        val state by movieDetailsViewModel.state.collectAsState(MovieDetailsState.Idle)
        val onEvent: (MovieDetailsUiEvent) -> Unit = { event ->
            when (event) {
                NavigateBack -> navController.navigate(AppNavigation.Close.route)
            }
        }
        MovieDetailsScreen(state, onEvent)
    }
}