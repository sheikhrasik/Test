package com.example.news.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news.models.Article
import com.example.news.network.NewsDataManger
import com.example.news.network.NewsResponse
import com.example.news.utils.CommonUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException

class NewsListViewModel : ViewModel() {

    var TAG = NewsListViewModel::class.java.simpleName


    private val newsDataManager by lazy { NewsDataManger() }

    val successfulGet: MutableLiveData<Boolean> = MutableLiveData()
    var articles = listOf<Article>()
    lateinit var message: String

    @SuppressLint("CheckResult")
    fun loadNews() {
        newsDataManager.getNews()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<NewsResponse>() {
                override fun onNext(newsResponse: NewsResponse) {
                    articles = newsResponse.articles
                    successfulGet.value = if (articles.isEmpty()) {
                        message = "No news available"
                        false
                    } else {
                        true
                    }
                }
                override fun onError(throwable: Throwable) {
                    message = when (throwable) {
                        is IOException -> {
                            "Failed to load news, please check your internet connection"
                        }
                        is TimeoutException -> {
                            "Request timed out"
                        }
                        is HttpException -> {
                            CommonUtils.getErrorResponse(throwable).message
                        }
                        else -> {
                            Log.e(TAG, "" + throwable.localizedMessage)
                            "Something went wrong"
                        }
                    }
                    successfulGet.value = false
                }
                override fun onComplete() {
                }
            })
    }
}
