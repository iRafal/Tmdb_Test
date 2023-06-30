package com.tmdb.data.db.room.di.component

import android.content.Context
import com.tmdb.utill.di.qualifiers.ApplicationContext

object DbComponentStore {
    private var _component: DbComponent? = null
    val component: DbComponent
        get() = checkNotNull(_component)

    fun init(@ApplicationContext applicationContext: Context) {
        if (_component != null) return

        val dependencies = object : DbComponentDependencies {
            override val applicationContext: Context
                get() = applicationContext
        }
        _component = DaggerDbComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}
