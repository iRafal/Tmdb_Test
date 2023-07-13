package com.tmdb.data.source.remote.impl.util.model

import com.tmdb.api.model.util.NetworkErrorModel

internal data class ApiErrorImpl(
    val reason: String = "An error"
) : NetworkErrorModel()
