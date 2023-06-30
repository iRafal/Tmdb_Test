package com.tmdb.utill.di.module

import com.tmdb.utill.di.qualifiers.ApplicationScope
import com.tmdb.utill.di.qualifiers.DispatcherDefault
import com.tmdb.utill.di.qualifiers.DispatcherIo
import com.tmdb.utill.di.qualifiers.DispatcherMain
import com.tmdb.utill.di.qualifiers.DispatcherUnconfined
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
object DispatchersModule {

    @[DispatcherIo Provides ApplicationScope]
    fun ioDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @[DispatcherMain Provides ApplicationScope]
    fun mainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @[DispatcherDefault Provides ApplicationScope]
    fun defaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @[DispatcherUnconfined Provides ApplicationScope]
    fun unconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
}
