package com.example.myweatherapp.weather.current.future.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweatherapp.repository.RemoteRepository
import com.example.myweatherapp.repository.entity.CurrentWeatherResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FutureListWeatherViewModel : ViewModel() {
   private val repository = RemoteRepository.getInstance()

    val weatherListLiveData = MutableLiveData<CurrentWeatherResponce>()

    fun getWeatherList () {
        repository.getWeatherCurrent()
            .enqueue(object : Callback<CurrentWeatherResponce> {
                override fun onFailure(call: Call<CurrentWeatherResponce>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CurrentWeatherResponce>,
                    response: Response<CurrentWeatherResponce>
                ) {
                weatherListLiveData.postValue(response.body())
                }

            })
    }
}
