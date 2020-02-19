package com.example.myweatherapp.repository.entity


import com.google.gson.annotations.SerializedName

data class CurrentWeatherEntry(
    val cloudcover: Int,
    val feelslike: Int,
    val humidity: Int,
    val localtime: String,
    @SerializedName("is_day")
    val isDay: String,
    @SerializedName("observation_time")
    val observationTime: String,
    val precip: Double,
    val pressure: Int,
    val temperature: Int,
    @SerializedName("uv_index")
    val uvIndex: Int,
    val visibility: Int,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Int,

    val country: String,
    val lat: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    val lon: String,
    @SerializedName("name")
    val location: String,
    val region: String,
    @SerializedName("timezone_id")
    val timezoneId: String,
    @SerializedName("utc_offset")
    val utcOffset: String
)