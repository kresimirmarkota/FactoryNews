package com.kreso.newsApp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ClientProvider {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    fun provideOkHttpClient(): OkHttpClient = okHttpClient

}