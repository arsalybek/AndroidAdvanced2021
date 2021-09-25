package com.raywenderlich.android.rwandroidtutorial.di

import com.raywenderlich.android.rwandroidtutorial.repository.todo.TodoRepository
import com.raywenderlich.android.rwandroidtutorial.repository.weather.WeatherRepository

interface DependencyInjector {
    fun weatherRepository() : WeatherRepository
    fun todoRepository(): TodoRepository
}