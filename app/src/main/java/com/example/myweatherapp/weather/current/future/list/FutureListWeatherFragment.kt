package com.example.myweatherapp.weather.current.future.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherapp.R
import com.example.myweatherapp.repository.entity.CurrentWeatherEntry
import com.example.myweatherapp.repository.entity.CurrentWeatherResponce
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.android.synthetic.main.current_weather_item.*
import kotlinx.android.synthetic.main.current_weather_item.textView_feels_like_temperature
import kotlinx.android.synthetic.main.current_weather_item.textView_temperature
import kotlinx.android.synthetic.main.current_weather_item.textView_weather_descriptions

class FutureListWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureListWeatherFragment()
    }

    private lateinit var viewModel: FutureListWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FutureListWeatherViewModel::class.java)
        viewModel.getWeatherList()
        viewModel.weatherListLiveData.observe(viewLifecycleOwner, listObserver)
        viewModel.weatherListLiveData.observe(viewLifecycleOwner, weatherListObserver)

    }

    private fun showData(list: List<CurrentWeatherEntry>) {
        val adapter = FutureListAdapter()
        adapter.list = list
        recycler_view.adapter = adapter
        recycler_view.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_view.setHasFixedSize(true)
    }

    @SuppressLint("SetTextI18n")
    private fun showCurrentWeather(data: CurrentWeatherEntry) {

        val weather_descriptions = data.weatherDescriptions.toString()
        val weather_icon: String = data.weatherIcons.toString()
        val temp = data.temperature.toString()
        val feels_like_temp = data.feelslike.toString()

        textView_weather_descriptions.text = weather_descriptions
        textView_temperature.text = "$temp \u2103 "
        textView_feels_like_temperature.text = "Feels like $feels_like_temp \u2103"

        Picasso.get()
            .load(weather_icon)
            .fit()
            .centerInside()
            .into(imageView_weather_icon)
    }

    private val weatherListObserver = Observer<CurrentWeatherResponce> { result ->
        showData(result.result)
    }
    private val listObserver = Observer<CurrentWeatherResponce> {
        it.currentWeatherEntry.let { result ->
            if (result != null) {
                showCurrentWeather(result)
            }
        }
    }
}
