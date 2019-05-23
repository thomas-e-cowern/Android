package com.example.androidnotesweek1

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.noterow.view.*

class NotesAdapter (val notes: List<String>) : RecyclerView.Adapter<NotesAdapter.NotesHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotesHolder {
        return NotesHolder(LayoutInflater.from(p0.context).inflate(R.layout.noterow, p0, false))
    }

    override fun getItemCount(): Int {
        return notes.count()
    }

    override fun onBindViewHolder(p0: NotesHolder, p1: Int) {
        val note = notes[p1]
        p0.bindNote(note)
    }

    class NotesHolder (v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view : View = v

        var note : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindNote(note : String) {
            this.note = note
            view.textView.text = note

        }

        override fun onClick(v: View?) {
            println("You clicked a note")
            val intent = Intent(view.context, notes_main::class.java)
            intent.putExtra("note", note)
            startActivity(view.context, intent, null)
        }

    }
}