package com.example.btvn

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var btnCheck: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Khởi tạo các view
        initViews()

        // Thiết lập sự kiện click cho nút
        setupClickListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        btnCheck = findViewById(R.id.btnCheck)
        tvResult = findViewById(R.id.tvResult)
    }

    private fun setupClickListeners() {
        btnCheck.setOnClickListener {
            checkUserInfo()
        }
    }

    private fun checkUserInfo() {
        val name = etName.text.toString().trim()
        val ageText = etAge.text.toString().trim()

        // Kiểm tra dữ liệu đầu vào
        if (name.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show()
            etName.requestFocus()
            return
        }

        if (ageText.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tuổi", Toast.LENGTH_SHORT).show()
            etAge.requestFocus()
            return
        }

        val age = try {
            ageText.toInt()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Tuổi phải là số", Toast.LENGTH_SHORT).show()
            etAge.requestFocus()
            return
        }

        if (age < 0 || age > 150) {
            Toast.makeText(this, "Tuổi không hợp lệ", Toast.LENGTH_SHORT).show()
            etAge.requestFocus()
            return
        }

        // Phân loại theo độ tuổi
        val category = when {
            age > 65 -> "Người già"
            age in 6..65 -> "Người lớn"
            age in 2..6 -> "Trẻ em"
            age >= 0 -> "Em bé"
            else -> "Không xác định"
        }

        // Hiển thị kết quả
        val result = """
            Thông tin người dùng:

            Họ và tên: $name
            Tuổi: $age
            Phân loại: $category

            ${getAgeGroupDescription(age)}
        """.trimIndent()

        tvResult.text = result
        tvResult.visibility = View.VISIBLE
    }

    private fun getAgeGroupDescription(age: Int): String {
        return when {
            age > 65 -> "Người già (>65 tuổi)"
            age in 6..65 -> "Người lớn (6-65 tuổi)"
            age in 2..6 -> "Trẻ em (2-6 tuổi)"
            age >= 0 -> "Em bé (≤2 tuổi)"
            else -> ""
        }
    }
}