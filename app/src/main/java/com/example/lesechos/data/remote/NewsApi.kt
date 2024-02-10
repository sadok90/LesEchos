package com.example.lesechos.data.remote

import com.example.lesechos.BuildConfig
import com.example.lesechos.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/everything")
    suspend fun getNews(
        @Query("q") query : String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY) : NewsResponse

}