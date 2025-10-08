package com.example.th2_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etEmail: EditText
    private lateinit var tvErrorMessage: TextView
    private lateinit var btnCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        initViews()

        // Set up button click listener
        setupButtonListener()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        tvErrorMessage = findViewById(R.id.tvErrorMessage)
        btnCheck = findViewById(R.id.btnCheck)
    }

    private fun setupButtonListener() {
        btnCheck.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val email = etEmail.text.toString().trim()

        // Reset error message
        tvErrorMessage.visibility = View.GONE
        resetEmailFieldStyle()

        when {
            email.isEmpty() -> {
                showError("Email không hợp lệ")
                highlightEmailField()
            }
            !email.contains("@") -> {
                showError("Email không đúng định dạng")
                highlightEmailField()
            }
            else -> {
                showSuccess("Bạn đã nhập email hợp lệ")
                highlightEmailFieldSuccess()
            }
        }
    }

    private fun showError(message: String) {
        tvErrorMessage.text = message
        tvErrorMessage.setTextColor(Color.parseColor("#FF5722"))
        tvErrorMessage.visibility = View.VISIBLE
    }

    private fun showSuccess(message: String) {
        tvErrorMessage.text = message
        tvErrorMessage.setTextColor(Color.parseColor("#4CAF50"))
        tvErrorMessage.visibility = View.VISIBLE
    }

    private fun highlightEmailField() {
        etEmail.setBackgroundResource(R.drawable.edittext_error_background)
    }

    private fun highlightEmailFieldSuccess() {
        etEmail.setBackgroundResource(R.drawable.edittext_success_background)
    }

    private fun resetEmailFieldStyle() {
        etEmail.setBackgroundResource(R.drawable.edittext_background)
    }
}