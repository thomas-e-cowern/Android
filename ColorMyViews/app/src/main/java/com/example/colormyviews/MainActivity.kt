package com.example.colormyviews

import android.graphics.Color
import android.graphics.Color.DKGRAY
import android.net.sip.SipSession
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    fun setListeners () {
        val clickableViews : List<View> = listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text, constraint_layout, button_one, button_two, button_three)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it)}
        }
    }

    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_red_light)

            R.id.button_one -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.button_two -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.button_three -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
