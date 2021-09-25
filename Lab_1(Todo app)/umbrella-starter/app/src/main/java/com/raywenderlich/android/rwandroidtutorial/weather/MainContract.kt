package com.raywenderlich.android.rwandroidtutorial.weather

import com.raywenderlich.android.rwandroidtutorial.base.BasePresenter
import com.raywenderlich.android.rwandroidtutorial.base.BaseView
import com.raywenderlich.android.rwandroidtutorial.repository.weather.WeatherState

interface MainContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLoadWeatherTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayWeatherState(weatherState: WeatherState)
    }
}