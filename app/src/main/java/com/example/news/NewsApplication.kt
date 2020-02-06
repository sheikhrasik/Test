package com.example.news

import android.app.Application
import android.content.Context

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {

        lateinit var instance: NewsApplication

        val context: Context
            get() = instance.applicationContext
    }
}
