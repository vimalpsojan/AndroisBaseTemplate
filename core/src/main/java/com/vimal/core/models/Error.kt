package com.vimal.core.models

import org.json.JSONObject
import retrofit2.Response
import java.io.Serializable

class Error : Serializable {

    var errorCode: Int = 500
    var message: String? = null
    var trace: String? = null
    var parameters: JSONObject? = null
    var url: String? = null
    var method: String? = null

    companion object {

        @JvmStatic
        fun <T> toError(response: Response<T>): Error {
            val error = Error()
            if (response.body() != null) {
                val body = (response.body() as DefaultResponse<*>)
                error.message = body.message
                error.trace = body.reason
                error.errorCode = body.code ?: 400
            } else {
                val responseJson = JSONObject(response.errorBody()?.string() ?: "{}")
                error.message = responseJson.optString("message")
                error.trace = responseJson.optString("trace")
                error.parameters = responseJson.optJSONObject("parameters")
                error.errorCode = response.code()
            }
            error.url = response.raw().request.url.toString()
            return error
        }
    }
}