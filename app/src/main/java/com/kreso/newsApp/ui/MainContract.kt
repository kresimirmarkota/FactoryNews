package com.kreso.newsApp.ui

import com.kreso.newsApp.model.Article

interface MainContract {

    interface View {
        fun showError(msg:String)
        fun setArticles (articles : List<Article>)
    }

    interface Presenter{
        fun fetchArticles()
    }
}