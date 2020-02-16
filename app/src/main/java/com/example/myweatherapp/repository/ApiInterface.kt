package com.example.myweatherapp.repository

import com.example.myweatherapp.repository.entity.CurrentWeatherResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("current")
    fun getWeatherCurrent(
        @Query("access_key") accessKey: String,
        @Query("query") query: String
    ): Call<CurrentWeatherResponce>
}