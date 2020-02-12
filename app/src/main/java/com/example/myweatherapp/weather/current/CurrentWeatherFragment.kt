package com.example.myweatherapp.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myweatherapp.R
import com.example.myweatherapp.repository.entity.CurrentWeatherEntry
import com.example.myweatherapp.repository.entity.CurrentWeathreResponce
import kotlinx.android.synthetic.main.current_weather_fragment.*

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        viewModel.weatherListLiveData.observe(viewLifecycleOwner, userListObserver)
        viewModel.getWeatherList()

    }

    fun showCurrentWeather(data: CurrentWeatherEntry?) {

        textView_weather_descriptions.text = data?.weatherDescriptions.toString()
//        imageView_weather_descriptions_icon = data?.weatherIcons
        textView_temperature.text = data?.temperature.toString()
        textView_feels_like_temperature.text = data?.feelslike.toString()
        textView_wind.text = data?.windSpeed.toString()
        textView_precipitation.text = data?.precip.toString()
        textView_visibility.text = data?.visibility.toString()

    }

    private val userListObserver = Observer<CurrentWeathreResponce> {
        it.currentWeatherEntry.let { result ->
            if (result != null) {
                showCurrentWeather(result)
            }
        }
    }

}
