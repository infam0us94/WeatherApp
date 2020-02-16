package com.example.myweatherapp.repository

import com.example.myweatherapp.repository.entity.CurrentWeatherResponce
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepository: Reposytory {

    init {
        createApi()
    }

    companion object {
        private var repo: RemoteRepository? = null

        fun getInstance(): RemoteRepository {
            if(repo == null) {
                repo = RemoteRepository()
            }
            return  repo!!
        }
    }

    private lateinit var api: ApiInterface
    private val token = "2047f2084fcf5e998a53118916e8f45c"
    private val query = "Minsk"

   override fun getWeatherCurrent(): Call <CurrentWeatherResponce> = api.getWeatherCurrent(
      token,
       query
   )

    private fun createApi() {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
                .build())
            .build()

        api = retrofit.create(ApiInterface ::class.java)

    }

}