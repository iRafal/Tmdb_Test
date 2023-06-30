package com.tmdb.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tmdb.feature.home.ui.HomeScreen
import com.tmdb.feature.movie.details.ui.MovieDetailsScreen
import com.tmdb.ui.core.compose.daggerViewModel
import com.tmdb.ui.core.navigation.model.NavigationRoute.Close
import com.tmdb.ui.core.navigation.model.NavigationRoute.Home
import com.tmdb.ui.core.navigation.model.NavigationRoute.MovieDetails
import com.tmdb.ui.di.component.UiComponentStore

fun NavGraphBuilder.appNavigationGraph(
    navController: NavController,
    onClose: () -> Unit
) {
    composable(Home.route) {
        val homeComponentViewModel = daggerViewModel { UiComponentStore.component.homeComponentViewModel }
        HomeScreen(navController)
    }
    composable(MovieDetails.route) {
        val movieDetailsComponentViewModel = daggerViewModel { UiComponentStore.component.movieDetailsComponentViewModel }
        val movieId = checkNotNull(it.arguments?.getString(MovieDetails.ARG_MOVIE_ID)?.toInt())
        MovieDetailsScreen(navController, movieId)
    }
    composable(Close.route) {
        onClose()
    }
}
