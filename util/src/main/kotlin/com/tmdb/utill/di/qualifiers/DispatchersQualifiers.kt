package com.tmdb.utill.di.qualifiers

import javax.inject.Qualifier

@[Qualifier Retention(AnnotationRetention.BINARY)]
annotation class DispatcherIo

@[Qualifier Retention(AnnotationRetention.BINARY)]
annotation class DispatcherMain

@[Qualifier Retention(AnnotationRetention.BINARY)]
annotation class DispatcherDefault

@[Qualifier Retention(AnnotationRetention.BINARY)]
annotation class DispatcherUnconfined
