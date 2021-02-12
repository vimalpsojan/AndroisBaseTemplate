package com.vimal.core.models

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class Event<out T>(private val data: T) {
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the data and prevents its use again.
     */
    fun get(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            data
        }
    }

    /**
     * Returns the data, even if it's already been handled.
     */
    fun peekContent(): T = data
}