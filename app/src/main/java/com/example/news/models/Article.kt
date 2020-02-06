package com.example.news.models

import java.util.*

data class Article(
    val author: String?,
    val title: String,
    val description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: Date,
    var content: String
)
