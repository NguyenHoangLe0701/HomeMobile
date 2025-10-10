package com.example.bai1_nhapsophople

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var inputNumber: EditText
    private lateinit var btnCreate: Button
    private lateinit var listContainer: LinearLayout
    private lateinit var tvError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        inputNumber = findViewById(R.id.inputNumber)
        btnCreate = findViewById(R.id.btnCreate)
        listContainer = findViewById(R.id.listContainer)
        tvError = findViewById(R.id.tvError)

        btnCreate.setOnClickListener {
            val input = inputNumber.text.toString().trim()

            // Reset trạng thái cũ
            listContainer.removeAllViews()
            tvError.text = ""
            tvError.visibility = TextView.GONE

            // Nếu rỗng → lỗi
            if (input.isEmpty()) {
                showError("Dữ liệu bạn nhập không hợp lệ")
                return@setOnClickListener
            }

            // Thử chuyển sang số
            try {
                val number = input.toInt()
                if (number <= 0) {
                    showError("Dữ liệu bạn nhập không hợp lệ")
                    return@setOnClickListener
                }

                // Sinh nút nếu hợp lệ
                for (i in 1..number) {
                    val btn = Button(this).apply {
                        text = i.toString()
                        setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
                        setTextColor(ContextCompat.getColor(context, android.R.color.white))
                        textSize = 16f
                        setPadding(0, 16, 0, 16)
                        val params = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        params.setMargins(0, 12, 0, 0)
                        layoutParams = params
                    }
                    listContainer.addView(btn)
                }

            } catch (e: NumberFormatException) {
                // Nếu người dùng nhập chữ như “a”, sẽ vào đây
                showError("Dữ liệu bạn nhập không hợp lệ")
            }
        }
    }

    // Hàm hiển thị lỗi
    private fun showError(message: String) {
        tvError.text = message
        tvError.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
        tvError.visibility = TextView.VISIBLE
    }
}
