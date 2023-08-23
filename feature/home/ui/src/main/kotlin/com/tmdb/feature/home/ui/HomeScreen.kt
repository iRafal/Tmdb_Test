package com.tmdb.feature.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.tmdb.feature.home.ui.HomeUiEvent.NavigateBack
import com.tmdb.feature.home.ui.HomeUiEvent.OpenMovie
import com.tmdb.feature.home.ui.HomeUiEvent.ReloadMovieSection
import com.tmdb.feature.home.ui.data.model.HomeUiData
import com.tmdb.feature.home.ui.di.homeFeatureComponent
import com.tmdb.ui.core.compose.daggerViewModel
import com.tmdb.ui.core.navigation.model.NavigationRoute

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val context = LocalContext.current
    val component = remember { context.homeFeatureComponent }
    val homeViewModel: HomeViewModel = daggerViewModel { component.homeViewModel }

    val data by homeViewModel.uiStateFlow.collectAsState(HomeUiData.INITIAL)

    val onEvent: (HomeUiEvent) -> Unit = { event ->
        when (event) {
            NavigateBack -> navController.navigate(NavigationRoute.Close.route)
            is OpenMovie -> {
                navController.navigate(
                    NavigationRoute.MovieDetails.getRouteNameWithArguments(event.id.toString())
                )
            }
            is ReloadMovieSection -> homeViewModel.onReloadMovieSection(event.movieSection)
        }
    }
    HomeScreenUi(data, onEvent)
}
