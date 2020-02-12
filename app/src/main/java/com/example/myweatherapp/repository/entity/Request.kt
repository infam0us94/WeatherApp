package com.example.myweatherapp.repository.entity


data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)