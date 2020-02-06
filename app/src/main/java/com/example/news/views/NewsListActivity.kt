package com.example.news.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.news.R
import com.example.news.viewmodels.NewsListViewModel

class NewsListActivity : AppCompatActivity() {

    private val newsListViewModel by lazy { ViewModelProviders.of(this).get(NewsListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        initViewModel()

        if (!newsListViewModel.articles.isNullOrEmpty()) {
            newsListViewModel.loadNews()
        }
    }

    private fun initViewModel() {
        newsListViewModel.successfulGet

        newsListViewModel.successfulGet.observe(this, Observer { successfulGet ->
            if (successfulGet != null) {
                if (successfulGet) {
                    //TODO: Show Recycler view
                    newsListViewModel.articles
                } else {
                    //TODO: Hide recycler view and show error
                }
                newsListViewModel.successfulGet.value = null
            }
        })
    }
}
