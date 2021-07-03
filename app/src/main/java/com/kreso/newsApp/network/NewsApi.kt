package com.kreso.newsApp.network

import com.kreso.newsApp.model.ArticlesResponse
import com.kreso.newsApp.model.People
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {


    @GET ("articles?source=bbc-news&sortBy=top&apiKey=6946d0c07a1c4555a4186bfcade76398")
    fun fetchArticles(): Call<ArticlesResponse>

}