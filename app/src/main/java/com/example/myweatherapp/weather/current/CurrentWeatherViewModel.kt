package com.example.myweatherapp.weather.current

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweatherapp.repository.RemoteRepository
import com.example.myweatherapp.repository.entity.CurrentWeathreResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentWeatherViewModel : ViewModel() {
    private val repository = RemoteRepository.getInstance()

    val weatherListLiveData  = MutableLiveData<CurrentWeathreResponce>()

    fun getWeatherList() {
        repository.getWeatherCurrent()
            .enqueue(object : Callback<CurrentWeathreResponce> {
                override fun onFailure(call: Call<CurrentWeathreResponce>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CurrentWeathreResponce>,
                    response: Response<CurrentWeathreResponce>
                ) {
                    weatherListLiveData.postValue(response.body())
                }
            })
    }
}
