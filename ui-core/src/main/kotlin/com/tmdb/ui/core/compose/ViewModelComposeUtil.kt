package com.tmdb.ui.core.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * https://proandroiddev.com/dagger-2-and-jetpack-compose-integration-8a8d424ffdb4
 */
@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: () -> T
): T =
    androidx.lifecycle.viewmodel.compose.viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelInstanceCreator() as T
            }
        }
    )
