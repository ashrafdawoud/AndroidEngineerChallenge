package com.dawoud.domain.utils

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error<out T>(val exception: Exception , val data : T?) : DataState<T>()
    object Loading : DataState<Nothing>()
}

