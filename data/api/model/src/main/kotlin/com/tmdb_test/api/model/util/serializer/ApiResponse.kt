package com.tmdb_test.api.model.util.serializer

sealed interface ApiResponse<out T : Any, out U : Any> {
    class Success<T : Any>(val data: T) : ApiResponse<T, Nothing>
    data class ApiError<U : Any>(
        val body: U? = null,
        val code: Int? = null
    ) : ApiResponse<Nothing, U>
    class NetworkError(val cause: ApiException.NetworkError? = null) :
        ApiResponse<Nothing, Nothing>
    class UnknownError(val cause: Throwable? = null) : ApiResponse<Nothing, Nothing>

    val isUnknownError: Boolean
        get() = this is UnknownError

    val isApiError: Boolean
        get() = this is ApiError

    val isNetworkError: Boolean
        get() = this is NetworkError

    val isSuccess: Boolean
        get() = this is Success<T>
}