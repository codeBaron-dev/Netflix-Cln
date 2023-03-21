package com.codebaron.shareddomain.remote

open class ResponseStates<out R> {
    object Loading : ResponseStates<Nothing>()
    data class Success<out T>(val data: T) : ResponseStates<T>()
    data class Exception(val exception: kotlin.Exception) : ResponseStates<Nothing>()
    data class ErrorMessage(val message: String?) : ResponseStates<Nothing>()
}