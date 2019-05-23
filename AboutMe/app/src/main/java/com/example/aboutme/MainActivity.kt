package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : MainActivityBinding

    private val myName: MyName = MyName("Tom Cowern")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)


        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickName(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

    }

    fun addNickName (view: View) {

        binding.apply {
            binding.nicknameText.text = nicknameEdit.text
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }


        //Hide the keyboard
        val kb = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        kb.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
