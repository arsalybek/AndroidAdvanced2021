package com.raywenderlich.android.rwandroidtutorial.di

import com.raywenderlich.android.rwandroidtutorial.repository.todo.TodoRepository
import com.raywenderlich.android.rwandroidtutorial.repository.todo.TodoRepositoryImpl
import com.raywenderlich.android.rwandroidtutorial.repository.weather.WeatherRepository
import com.raywenderlich.android.rwandroidtutorial.repository.weather.WeatherRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {
    override fun weatherRepository() : WeatherRepository {
        return WeatherRepositoryImpl()
    }
    override fun todoRepository() : TodoRepository {
        return TodoRepositoryImpl()
    }
}