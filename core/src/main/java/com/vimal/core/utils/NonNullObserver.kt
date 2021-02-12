package com.vimal.core.utils

import androidx.lifecycle.Observer
import com.vimal.core.models.Event

/**
 * An [Observer] for non null values , simplifying the pattern of checking if the value emitted null
 *
 * [onContent] is *only* called if the [Event]'s contents has not been handled.
 */
class NonNullObserver<T>(private val onContent: (T) -> Unit) : Observer<T> {
    override fun onChanged(event: T?) {
        event?.let { value ->
            onContent(value)
        }
    }
}