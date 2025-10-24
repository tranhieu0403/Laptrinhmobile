package com.example.btvn1.model

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object LibraryManager {
    val books = mutableListOf(
        Book(1, "Sách Toán"),
        Book(2, "Sách Lý"),
        Book(3, "Sách Tiếng Anh"),
        Book(4, "Sách Hoá")
    )

    val students = mutableListOf(
        Student(1, "Tran Duc Hieu"),
        Student(2, "Tran Van Tuan"),
        Student(3, "Nguyen Hoai Phong"),
        Student(4, "Pham Nhat Vuong")
    )

    // ⚡ Compose sẽ recompose ngay khi student đổi
    var currentStudent by mutableStateOf(students[0])
}
