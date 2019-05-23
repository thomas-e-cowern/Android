package com.example.todoer

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.todorow.view.*

class ToDoAdapter(val todos: List<String>) : RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ToDoHolder {
       return ToDoHolder(LayoutInflater.from(p0.context).inflate(R.layout.todorow, p0, false))
    }

    override fun getItemCount(): Int {
        return todos.count()
    }

    override fun onBindViewHolder(p0: ToDoHolder, p1: Int) {
       val title = todos[p1]
        p0.bindTodo(title)
    }

    class ToDoHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view : View = v
        var title : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindTodo(title: String) {
            this.title = title
            view.textView.text = title
        }

        override fun onClick(p0: View?) {
            val intent = Intent(view.context, CompleteToDoActivity::class.java)
            intent.putExtra("title", title)
            startActivity(view.context, intent, null)
        }
    }

}