package com.example.myweatherapp.weather.current.future.list

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
import kotlinx.android.synthetic.main.future_list_weather_fragment.*

class FutureListWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureListWeatherFragment()
    }

    private lateinit var viewModel: FutureListWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_list_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FutureListWeatherViewModel::class.java)
        viewModel.getWeatherList()
        viewModel.weatherListLiveData.observe(viewLifecycleOwner, weatherListObserver)
    }

    private fun showData(list: List<CurrentWeatherEntry>) {
        val adapter = FutureListAdapter()
        adapter.list = list
        recycler_view.adapter = adapter
        recycler_view.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)


    }

    private val weatherListObserver = Observer<CurrentWeatherResponce> {result ->
showData(result.result)

    }

}
