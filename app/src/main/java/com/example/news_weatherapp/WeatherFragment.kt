package com.example.news_weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherList = mutableListOf<WeatherItems>().apply {
            add(WeatherItems(R.drawable.sunny_icon, "Monday", "Sunny,no wind,25°C"))
            add(WeatherItems(R.drawable.sunny_icon, "Tuesday", "Sunny,mild wind,23°C"))
            add(WeatherItems(R.drawable.cloudy_icon, "Wednesday", "Cloudy,mild wind,21°C"))
            add(WeatherItems(R.drawable.rain_icon, "Thursday", "Small showers, light wind, 19°C"))
            add(WeatherItems(R.drawable.rain_icon, "Friday", "Rainy, strong wind, 17°C"))
            add(WeatherItems(R.drawable.cloudy_icon, "Saturday", "Partly sunny, mild wind,20°C"))
            add(WeatherItems(R.drawable.sunny_icon, "Sunday", "Partly cloudy, light wind, 22°C"))
            add(WeatherItems(R.drawable.sunny_icon, "June 20", "Sunny, no wind, 25°C"))
            add(WeatherItems(R.drawable.sunny_icon, "June 21", "Sunny, mild wind, 24°C"))
            add(WeatherItems(R.drawable.sunny_icon, "June 22", "Sunny, no wind, 26°C"))
        }

        val weatherRecyclerAdapter = WeatherRecyclerAdapter()
        weatherRecyclerAdapter.weatherData = weatherList
        val recyclerView: RecyclerView = view.findViewById(R.id.weather_recyclerview)
        recyclerView.adapter = weatherRecyclerAdapter

    }
}