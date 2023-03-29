package com.tmdb.data.source.local.impl.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
object UnitTestServiceLocator {

    val textDispatcher = StandardTestDispatcher()
}