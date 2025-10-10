package com.example.baitap2activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.baitap2activity.R
class BaiTap2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai_tap2)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnKiemTra = findViewById<Button>(R.id.btnKiemTra)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        btnKiemTra.setOnClickListener {
            val email = edtEmail.text.toString().trim()

            when {
                email.isEmpty() -> {
                    tvMessage.text = "Email không hợp lệ"
                    tvMessage.setTextColor(getColor(android.R.color.holo_red_dark))
                    tvMessage.visibility = TextView.VISIBLE
                }
                !email.contains("@") -> {
                    tvMessage.text = "Email không đúng định dạng"
                    tvMessage.setTextColor(getColor(android.R.color.holo_red_dark))
                    tvMessage.visibility = TextView.VISIBLE
                }
                else -> {
                    tvMessage.text = "Bạn đã nhập email hợp lệ"
                    tvMessage.setTextColor(getColor(android.R.color.holo_green_dark))
                    tvMessage.visibility = TextView.VISIBLE
                }
            }
        }
    }
}
