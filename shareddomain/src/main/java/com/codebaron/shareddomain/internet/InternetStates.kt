package com.codebaron.shareddomain.internet

open class InternetStates<out R> {
    data class IsInternetAvailable<out T>(val isInternetAvailable: Boolean) : InternetStates<T>()
    data class HasInternetStateChanged<out T>(val hasInternetStateChanged: Boolean) : InternetStates<T>()
    data class IsInternetConnectionLost<out T>(val isInternetConnectionLost: Boolean) : InternetStates<T>()
}