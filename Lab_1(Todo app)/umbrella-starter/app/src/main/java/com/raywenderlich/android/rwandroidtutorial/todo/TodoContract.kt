package com.raywenderlich.android.rwandroidtutorial.todo

import com.raywenderlich.android.rwandroidtutorial.base.BasePresenter
import com.raywenderlich.android.rwandroidtutorial.base.BaseView
import com.raywenderlich.android.rwandroidtutorial.repository.todo.Todo

interface TodoContract {
    interface Presenter : BasePresenter {
        fun getTodoList(): MutableList<Todo>
        fun onTodoTaskAdded(todo: Todo)
    }

    interface View : BaseView<Presenter> {
        fun showTodoTasks(todoList: List<Todo>)
    }
}