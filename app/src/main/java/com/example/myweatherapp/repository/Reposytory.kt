package com.example.myweatherapp.repository

import com.example.myweatherapp.repository.entity.CurrentWeathreResponce
import retrofit2.Call

interface Reposytory {

    fun getWeatherCurrent() : Call<CurrentWeathreResponce>
}