package com.kreso.newsApp.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiServiceProvider {

    private val newsApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v1/")
            .addConverterFactory(MoshiConverterFactory.create(MoshiProvider.moshi))
            .client(ClientProvider.provideOkHttpClient())
            .build()

        retrofit.create(NewsApi::class.java)
    }

    fun provideNewsApi():NewsApi= newsApi
}