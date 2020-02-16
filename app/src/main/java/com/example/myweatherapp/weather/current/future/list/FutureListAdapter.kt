package com.example.myweatherapp.weather.current.future.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp.R
import com.example.myweatherapp.repository.entity.CurrentWeatherResponce

class FutureListAdapter() :
    RecyclerView.Adapter<FutureListAdapter.ViewHolder>() {

    var list = emptyList<CurrentWeatherResponce>()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val date: TextView = itemView.findViewById(R.id.textView_date)
        private val temperature: TextView = itemView.findViewById(R.id.textView_temperature)
        private val condition: TextView = itemView.findViewById(R.id.textView_condition)
        private val conditionIcon: ImageView = itemView.findViewById(R.id.imageView_condition_icon)


        fun bind(data: CurrentWeatherResponce) {

            date.text = data.location?.localtime.toString()
            temperature.text = data.currentWeatherEntry?.temperature.toString()
            condition.text = data.currentWeatherEntry?.weatherDescriptions.toString()
//            conditionIcon.drawable = data.weatherIcons
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.future_weather_cardview,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = list[position]
        holder.bind(currentItem)

    }
}