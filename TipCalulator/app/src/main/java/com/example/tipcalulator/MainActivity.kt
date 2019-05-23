package com.example.tipcalulator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalTextView.visibility = View.INVISIBLE

        calculateButton.setOnClickListener {
            // Bill
            var bill = billEditText.text.toString().toDouble()

            // Tip Percentage
            var tip = tipPercentEditText.text.toString().toDouble() / 100

            // Tip
            var tipAmount = bill * tip

            // Total
            var total = tipAmount + bill


            // Set total text
            totalTextView.text = "Tip: ${doubleToDollar(tipAmount)}  Total: ${doubleToDollar(total)}"
            totalTextView.visibility = View.VISIBLE
        }
    }

    fun doubleToDollar(number: Double): String {
        return "$" + String.format("%.2f", number)
    }
}
