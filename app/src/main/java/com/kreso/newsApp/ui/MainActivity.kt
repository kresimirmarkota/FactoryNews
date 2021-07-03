package com.kreso.newsApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kreso.newsApp.R
import com.kreso.newsApp.model.Article
import com.kreso.newsApp.model.ArticlesResponse
import com.kreso.newsApp.network.ApiServiceProvider
import com.kreso.newsApp.ui.adapter.ArticlesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter : MainContract.Presenter
    private val newsAdapter=ArticlesAdapter()
    val sharedpref = getSharedPreferences("savedSharedPreferences", MODE_PRIVATE)
    val editor = sharedpref.edit()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= MainPresenter(this)
        presenter.fetchArticles()
        editor.apply(){

        }
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.adapter=newsAdapter

    }

   override fun setArticles (articles : List<Article>){
        newsAdapter.setData(articles)
    }

    override fun showError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}