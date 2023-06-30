package com.tmdb.data.db.realm.di.component.app

import android.app.Instrumentation
import android.content.Context
import androidx.test.espresso.internal.inject.InstrumentationContext
import com.tmdb.data.db.realm.di.component.db.TestDbComponent
import com.tmdb.data.db.realm.di.module.DispatchersTestModule
import com.tmdb.data.db.realm.di.module.TestAppModule
import dagger.Component
import kotlinx.coroutines.test.TestDispatcher

@Component(modules = [TestAppModule::class, DispatchersTestModule::class])
interface TestAppComponent {
    val instrumentation: Instrumentation

    @InstrumentationContext
    val instrumentationContext: Context

    @DispatchersTestModule.DispatcherTestUnconfined
    fun unconfinedTestDispatcher(): TestDispatcher

    @DispatchersTestModule.DispatcherTestStandard
    fun standardTestDispatcher(): TestDispatcher

    val testDbComponentBuilder: TestDbComponent.Builder

    @dagger.Component.Builder
    interface Builder {
        fun build(): TestAppComponent
    }
}
