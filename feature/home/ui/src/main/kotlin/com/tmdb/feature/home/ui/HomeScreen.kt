package com.tmdb.feature.home.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
) {
//    val context = LocalContext.current
//    val component = remember { HomeFeatureDi.fromContext(context) }
//    val homeViewModel: HomeViewModel = daggerViewModel { component.homeViewModel }
//
//    val data by homeViewModel.uiStateFlow.collectAsState(HomeUiData.INITIAL)
//
//    val onEvent: (HomeUiEvent) -> Unit = { event ->
//        when (event) {
//            NavigateBack -> navController.navigate(NavigationRoute.Close.route)
//            is OpenMovie -> {
//                navController.navigate(
//                    NavigationRoute.MovieDetails.getRouteNameWithArguments(event.id.toString())
//                )
//            }
//            is ReloadMovieSection -> homeViewModel.onReloadMovieSection(event.movieSection)
//        }
//    }
//    HomeScreenUi(data, onEvent)
}
