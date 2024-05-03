package com.techuntried.jetpackcomposemvvm.api

import com.techuntried.jetpackcomposemvvm.models.TweetItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    @GET("/v3/b/6634d4e7acd3cb34a8425f20?meta=false")
    suspend fun getTweetsCategory(): Response<List<String>>


    @GET("/v3/b/6634bc0dad19ca34f863dcdc?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetItem>>

}



