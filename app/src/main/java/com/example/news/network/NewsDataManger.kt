package com.example.news.network

import io.reactivex.Observable

class NewsDataManger {

    private val apiManager = ApiManager.instance

    fun getNews(): Observable<NewsResponse> {
        return apiManager.newsService.getNews()
    }
}
