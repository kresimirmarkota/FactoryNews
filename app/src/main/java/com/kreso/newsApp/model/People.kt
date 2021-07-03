package com.kreso.newsApp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class People(
    @Json(name="name")
    val name: String,
    @Json(name="height")
    val height: String
)
