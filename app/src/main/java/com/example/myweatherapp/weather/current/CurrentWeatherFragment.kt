package com.example.myweatherapp.weather.current

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myweatherapp.R
import com.example.myweatherapp.repository.entity.CurrentWeatherEntry
import com.example.myweatherapp.repository.entity.CurrentWeatherResponce
import com.squareup.picasso.Picasso
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

    @SuppressLint("SetTextI18n")
    fun showCurrentWeather(data: CurrentWeatherEntry) {

        val weather_descriptions = data.weatherDescriptions.toString()
        val weather_icon: String = data.weatherIcons.toString()
        val temp = data.temperature.toString()
        val feels_like_temp = data.feelslike.toString()
        val wind = data.windSpeed.toString()
        val precipitation = data.precip.toString()
        val visibility = data.visibility.toString()
        val wind_dir = data.windDir

        textView_location.text = data.location
        textView_weather_descriptions.text = weather_descriptions
        textView_temperature.text = "$temp \u2103 "
        textView_feels_like_temperature.text = "Feels like $feels_like_temp \u2103"
        textView_wind.text = "Wind $wind_dir, $wind m/s"
        textView_precipitation.text = "Precipitation: $precipitation mm"
        textView_visibility.text = "Visibility: $visibility km"
        Picasso.get()
            .load(weather_icon)
            .fit()
            .centerInside()
            .into(imageView_weather_icon)

        group_loading.visibility = View.GONE
    }

    private val userListObserver = Observer<CurrentWeatherResponce> {
        it.currentWeatherEntry.let { result ->
            if (result != null) {
                showCurrentWeather(result)
            }
        }
    }
}
