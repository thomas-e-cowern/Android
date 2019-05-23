package com.example.androidnotesweek1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notes_main.*

class notes_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_main)

        var newNote = false
        var oldNote = ""

        if (noteTextField.text.toString() != "") {
            newNote = true
        } else {
            oldNote = intent.extras.getString("note").toString()
            noteTextField.setText(oldNote)
        }




        saveButton.setOnClickListener {
            val note = noteTextField.text.toString()

            var prefs = getSharedPreferences("com.example.androidnotesweek1.sharedPrefs", Context.MODE_PRIVATE)

            var notes = prefs.getStringSet("notestring", setOf()).toMutableSet()

            if (newNote == true) {
                notes.add(note)
                prefs.edit().putStringSet("notestring", notes).apply()
            } else {
                notes.remove(oldNote)
                notes.add(note)
                prefs.edit().putStringSet(getString(R.string.notes_strings), notes).apply()
            }


            finish()
        }

    }
}
