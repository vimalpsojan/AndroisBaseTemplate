package com.vimal.core.models

import androidx.annotation.Keep

@Keep
data class APIResult<T>(
        val statusCode: Int,
        val isSuccess: Boolean = false,
        val data: T? = null,
        val error: Error? = null,
        val message: String?
)