package com.kreso.newsApp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kreso.newsApp.R
import com.kreso.newsApp.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private val articles : MutableList<Article> = mutableListOf()

    fun setData(articles :List<Article>){
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(private val view: View ): RecyclerView.ViewHolder(view){
        fun bind(article :Article){
            view.articleTitleTextView.text = article.title
            Glide.with(view.context).load(article.urlToImage).into(view.articleImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int {

        return articles.size
    }

}