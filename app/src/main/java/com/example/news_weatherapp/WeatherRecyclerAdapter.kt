package com.example.news_weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherRecyclerAdapter : RecyclerView.Adapter<WeatherRecyclerAdapter.ViewHolder>() {

    var weatherData = emptyList<WeatherItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_items_recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(weatherData[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val date: TextView = itemView.findViewById(R.id.date)
        private val picture: ImageView = itemView.findViewById(R.id.weather_image)
        private val forecast: TextView = itemView.findViewById(R.id.weather_description)

        fun bind(weather: WeatherItems) {

            date.text = weather.date
            picture.setImageResource(weather.picture)
            forecast.text = weather.forecast
        }

    }

}