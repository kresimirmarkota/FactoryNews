package com.kreso.newsApp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.sql.Timestamp

@JsonClass(generateAdapter = true)
data class ArticlesResponse(
    @Json(name="articles")
    val articles:List<Article>,
    val timestamp : Long = System.currentTimeMillis()

)
