package com.example.myweatherapp.repository.entity

import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponce(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry? = null,
    val result: List<CurrentWeatherEntry>,
    val location: Location? = null,
    val request: Request? = null
)