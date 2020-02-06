package com.example.news.models

data class ServerError(
    val status: String,
    val code: String,
    val message: String
)
