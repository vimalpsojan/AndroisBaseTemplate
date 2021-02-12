package com.vimal.sample.api

import com.vimal.core.models.DefaultResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET(APIUrls.GET_ALL_NUMBERS)
    fun getAllNumbers(@Query("intStartNo")start:Int, @Query("intEndNo")end:Int): Single<Result<DefaultResponse<List<String>>>>

}