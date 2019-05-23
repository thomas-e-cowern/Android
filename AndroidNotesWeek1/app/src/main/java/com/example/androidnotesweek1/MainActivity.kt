package com.example.androidnotesweek1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton.setOnClickListener {
            println("You clicked the button")
            val intent = Intent(this, notes_main::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()


        var prefs = getSharedPreferences(getString(R.string.shared_prefs_name), Context.MODE_PRIVATE)

        var notes = prefs.getStringSet(getString(R.string.notes_strings), setOf()).toMutableSet()

        layoutManager = LinearLayoutManager(this)
        notesView.layoutManager = layoutManager

        adapter = NotesAdapter(notes.toList())
        notesView.adapter = adapter
        
    }
}
