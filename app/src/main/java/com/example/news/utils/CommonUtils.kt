package com.example.news.utils

import com.example.news.models.ServerError
import com.google.gson.Gson
import retrofit2.HttpException


object CommonUtils {
 fun getErrorResponse(exception: HttpException): ServerError {
        val response = exception.response()?.errorBody()?.string()
        return Gson().fromJson(response.toString(), ServerError::class.java)
    }
}
