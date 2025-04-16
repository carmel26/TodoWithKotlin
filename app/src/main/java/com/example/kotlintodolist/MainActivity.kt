package com.example.kotlintodolist

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintodolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access all views using binding.rvToDoItems, etc.
        todoAdapter = TodoAdapter(mutableListOf())
        binding.rvToDoItems.adapter = todoAdapter

        binding.rvToDoItems.layoutManager = LinearLayoutManager(this)

//        adding a new todo function
        binding.btnAddButton.setOnClickListener {
            val todoTitle = binding.edTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = ToDo(todoTitle)
                todoAdapter.addTodo(todo)
                binding.edTodoTitle.text.clear()
            }else{
                println("I got this: $todoTitle")
                Log.i(TAG, "Hello World")
            }
        }

//        delete a todo from our list
        binding.btnDeleteDoneToDoes.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

    }
}