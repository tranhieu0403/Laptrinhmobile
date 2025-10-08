package com.example.th2_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNumberInput: EditText
    private lateinit var btnCreate: Button
    private lateinit var tvError: TextView
    private lateinit var llNumberButtons: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setupListeners()
    }

    private fun initViews() {
        etNumberInput = findViewById(R.id.etNumberInput)
        btnCreate = findViewById(R.id.btnCreate)
        tvError = findViewById(R.id.tvError)
        llNumberButtons = findViewById(R.id.llNumberButtons)
    }

    private fun setupListeners() {
        btnCreate.setOnClickListener {
            val inputText = etNumberInput.text.toString().trim()

            // Hide error message and number buttons initially
            tvError.visibility = View.GONE
            llNumberButtons.visibility = View.GONE

            if (inputText.isEmpty()) {
                showError()
                return@setOnClickListener
            }

            try {
                val number = inputText.toInt()
                if (number > 0) {
                    // Valid number, show number buttons
                    createNumberButtons(number)
                    llNumberButtons.visibility = View.VISIBLE
                } else {
                    // Invalid number (zero or negative)
                    showError()
                }
            } catch (e: NumberFormatException) {
                // Invalid input (not a number)
                showError()
            }
        }
    }

    private fun showError() {
        tvError.visibility = View.VISIBLE
        llNumberButtons.visibility = View.GONE
    }

    private fun createNumberButtons(count: Int) {
        llNumberButtons.removeAllViews()

        for (i in 1..count) {
            val button = Button(this).apply {
                text = i.toString()
                textSize = 18f
                setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.white))
                background = ContextCompat.getDrawable(this@MainActivity, R.drawable.number_button_background)

                // Set layout parameters
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    120 // 48dp converted to pixels approximately
                ).apply {
                    setMargins(0, 0, 0, 16)
                }
                this.layoutParams = layoutParams

                // Set click listener
                setOnClickListener {
                    Toast.makeText(this@MainActivity, "Bạn đã chọn số $i", Toast.LENGTH_SHORT).show()
                }
            }

            llNumberButtons.addView(button)
        }
    }
}