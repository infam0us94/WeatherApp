package com.example.myweatherapp.repository.entity

import com.google.gson.annotations.SerializedName


data class CurrentWeathreResponce(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry? = null,
    val location: Location? = null,
    val request: Request? = null
)