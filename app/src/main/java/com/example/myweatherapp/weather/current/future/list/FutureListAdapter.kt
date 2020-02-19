package com.example.myweatherapp.weather.current.future.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp.R
import com.example.myweatherapp.repository.entity.CurrentWeatherEntry
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.future_weather_cardview.view.*

class FutureListAdapter : RecyclerView.Adapter<FutureListAdapter.ViewHolder>() {

    var list = emptyList<CurrentWeatherEntry>()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date: TextView = itemView.textView_date
        val temperature: TextView = itemView.textView_temperature
        val condition: TextView = itemView.textView_condition
        val conditionIcon: ImageView = itemView.imageView_condition_icon


        fun bind(data: CurrentWeatherEntry) {

            date.text = data.localtime
            temperature.text = data.temperature.toString()
            condition.text = data.weatherDescriptions.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.future_weather_cardview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = list[position]
        holder.bind(currentItem)

    }
}