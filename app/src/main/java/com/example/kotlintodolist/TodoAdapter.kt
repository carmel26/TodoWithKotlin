package com.example.kotlintodolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

//    function to add todos
    fun addTodo(todo: ToDo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

//    function to removeTodo
fun deleteDoneTodos() {
    todos.removeAll { todo ->
        todo.isChecked
    }
    notifyDataSetChanged()
}

    // to change the flag when checked or uncheck
    private fun toggleStrikeThrough(tvTodoTitle : TextView, isChecked : Boolean){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTod = todos[position]
        val tvTodoTitle = holder.binding.tvTodoTitle
        val cbDone = holder.binding.cbDone
        tvTodoTitle.text = currentTod.title
        cbDone.isChecked = currentTod.isChecked
        toggleStrikeThrough(tvTodoTitle, currentTod.isChecked)
        cbDone.setOnCheckedChangeListener { _, isChecked ->
            toggleStrikeThrough(tvTodoTitle, isChecked)
            currentTod.isChecked = !currentTod.isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}

