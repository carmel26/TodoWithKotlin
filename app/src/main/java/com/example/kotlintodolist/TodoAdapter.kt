package com.example.kotlintodolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintodolist.databinding.ItemtodoBinding


class TodoAdapter (private val todos : MutableList<ToDo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemtodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoViewHolder {
       val binding = ItemtodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTod = todos[position]
        holder.binding.tvTodoTitle.text = currentTod.title
        holder.binding.cbDone.isChecked = currentTod.isCheck
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}

