package com.example.news.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.news.R

class NewsDetailActivity : AppCompatActivity() {

    private val mImageView: ImageView = findViewById(R.id.image_view)
    private val mTextView: TextView = findViewById(R.id.text_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        this.mImageView
        this.mTextView
    }
}
