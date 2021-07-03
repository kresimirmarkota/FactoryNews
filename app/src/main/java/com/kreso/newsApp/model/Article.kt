package com.kreso.newsApp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val url : String,
    @Json(name = "urlToImage")
    val urlToImage: String
    )
