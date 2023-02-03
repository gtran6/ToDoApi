package com.example.todoapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapi.model.apiResponse
import com.example.todoapi.model.apiResponseItem
import com.example.todoapi.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val data = MutableLiveData<List<apiResponseItem>>()

    fun getTodoData() {
        RetrofitInstance.apiRetrofit.getToDoList()
            .enqueue(object : Callback<apiResponse?> {
                override fun onResponse(
                    call: Call<apiResponse?>,
                    response: Response<apiResponse?>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<apiResponse?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}