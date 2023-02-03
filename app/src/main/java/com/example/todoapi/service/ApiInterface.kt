package com.example.todoapi.service

import com.example.todoapi.model.apiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/todos")
    fun getToDoList(): Call<apiResponse>
}