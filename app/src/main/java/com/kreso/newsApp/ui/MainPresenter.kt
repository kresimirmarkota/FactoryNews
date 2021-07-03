package com.kreso.newsApp.ui

import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kreso.newsApp.model.ArticlesResponse
import com.kreso.newsApp.network.ApiServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (private val view : MainContract.View) : MainContract.Presenter{
    private val newsApi= ApiServiceProvider.provideNewsApi()


   override fun fetchArticles(){
       //dodati if i u tom ifu povuci podatke iz lokalne prohrane i provjeriti je li trenutni timestamp veći od 5 min
        newsApi.fetchArticles().enqueue(object : Callback<ArticlesResponse> {
            override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                response.body()?.articles?.let {
                    view.setArticles(it) }
            }

            override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
               view.showError(t.message.toString())

            }
        })
    }

}