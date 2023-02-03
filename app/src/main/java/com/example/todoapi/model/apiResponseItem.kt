package com.example.todoapi.model

data class apiResponseItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)