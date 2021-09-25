/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.rwandroidtutorial.todo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.raywenderlich.android.rwandroidtutorial.R
import com.raywenderlich.android.rwandroidtutorial.di.DependencyInjectorImpl
import com.raywenderlich.android.rwandroidtutorial.repository.todo.Todo
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity(), TodoContract.View {
    private lateinit var presenter: TodoContract.Presenter
    private lateinit var todoListAdapter: TodoAdapter
    private lateinit var curTodoList: MutableList<Todo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        setPresenter(TodoPresenter(this, DependencyInjectorImpl()))

        curTodoList = presenter.getTodoList()

        todoListAdapter = TodoAdapter(curTodoList)

        todoList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = todoListAdapter
        }

        addButton.setOnClickListener {
            presenter.onTodoTaskAdded(Todo(textInput.text.toString()))
            textInput.setText("")
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTodoTasks(todoList: List<Todo>) {
        curTodoList = todoList.toMutableList()
        todoListAdapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: TodoContract.Presenter) {
        this.presenter = presenter
    }
}

