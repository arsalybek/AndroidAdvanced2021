package com.raywenderlich.android.rwandroidtutorial.weather

import com.raywenderlich.android.rwandroidtutorial.di.DependencyInjector
import com.raywenderlich.android.rwandroidtutorial.repository.weather.Weather
import com.raywenderlich.android.rwandroidtutorial.repository.weather.WeatherRepository
import com.raywenderlich.android.rwandroidtutorial.repository.weather.WeatherState

class MainPresenter(view: MainContract.View,
                    dependencyInjector: DependencyInjector
)
    : MainContract.Presenter {
    // 2
    private val weatherRepository: WeatherRepository = dependencyInjector.weatherRepository()

    // 3
    private var view: MainContract.View? = view

    private fun loadWeather() {
        val weather = weatherRepository.loadWeather()
        val weatherState = weatherStateForWeather(weather)
        view?.displayWeatherState(weatherState)
    }

    private fun weatherStateForWeather(weather: Weather) : WeatherState {
        if (weather.rain!!.amount!! > 0) {
            return WeatherState.RAIN
        }
        return WeatherState.SUN
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadWeather()
    }

    override fun onLoadWeatherTapped() {
        loadWeather()
    }
}