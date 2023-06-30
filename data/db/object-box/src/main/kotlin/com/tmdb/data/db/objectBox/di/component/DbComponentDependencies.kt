package com.tmdb.data.db.objectBox.di.component

import android.content.Context
import com.tmdb.utill.di.qualifiers.ApplicationContext

interface DbComponentDependencies {
    @get:ApplicationContext
    val applicationContext: Context
}
