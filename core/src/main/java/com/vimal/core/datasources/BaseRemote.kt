package com.vimal.core.datasources

import com.vimal.core.models.APIResult
import com.vimal.core.models.DefaultResponse
import com.vimal.core.models.Error
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.adapter.rxjava3.Result

abstract class BaseRemote {
    private fun <T> getError(response: Response<T>): Error {
        return Error.toError(response)
    }

    fun <T> Single<Result<DefaultResponse<T>>>.createResult(): Single<APIResult<T>> {
        return map {
            it.createResult()
        }
    }

    @Throws(Throwable::class)
    private fun <T> Result<DefaultResponse<T>>.createResult(): APIResult<T> {
        if (this.isError) {
            throw this.error()!!
        }
        val response = this.response()!!
        return if (response.isSuccessful && response.body()?.data != null)
            APIResult(response.code(), response.isSuccessful, response.body()?.data, null, response.message())
        else
            APIResult(response.code(), false, null, getError(response), response.message())
    }
}