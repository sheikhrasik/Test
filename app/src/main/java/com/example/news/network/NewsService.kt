package com.example.news.network

import io.reactivex.Observable
import retrofit2.http.GET

interface NewsService {

    @GET("")
    fun getNews(): Observable<NewsResponse>
}
