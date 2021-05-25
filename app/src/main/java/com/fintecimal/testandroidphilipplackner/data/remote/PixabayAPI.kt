package com.fintecimal.testandroidphilipplackner.data.remote

import com.fintecimal.testandroidphilipplackner.BuildConfig
import com.fintecimal.testandroidphilipplackner.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {
    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searQuery: String,
        @Query("key") apiKey: String = BuildConfig.Api_key
    ) : Response<ImageResponse>

}