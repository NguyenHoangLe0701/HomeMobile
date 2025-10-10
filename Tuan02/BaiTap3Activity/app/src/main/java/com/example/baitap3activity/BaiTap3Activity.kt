package com.example.baitap3activity.tuan02.baitap3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.HtmlCompat // Dùng thư viện hỗ trợ HTML
import com.example.baitap3activity.databinding.ActivityBaiTap3Binding


class BaiTap3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityBaiTap3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Khởi tạo View Binding
        binding = ActivityBaiTap3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Thiết lập sự kiện click cho nút "Kiểm tra"
        binding.btnKiemTra.setOnClickListener {
            kiemTraDoTuoi()
        }
    }

    private fun kiemTraDoTuoi() {
        // 1. Lấy dữ liệu
        val hoTen = binding.edtHoVaTen.text.toString().trim()
        val tuoiText = binding.edtTuoi.text.toString().trim()

        // 2. Kiểm tra dữ liệu trống
        if (hoTen.isEmpty() || tuoiText.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            binding.tvKetQua.text = "⚠️ Chưa nhập đủ thông tin!"
            return
        }

        // 3. Chuyển đổi tuổi sang số và kiểm tra tính hợp lệ
        val tuoi: Int
        try {
            tuoi = tuoiText.toInt()
            if (tuoi < 0 || tuoi > 150) {
                Toast.makeText(this, "Tuổi không hợp lệ (0-150)", Toast.LENGTH_SHORT).show()
                binding.tvKetQua.text = "⚠️ Tuổi phải là số dương hợp lý!"
                return
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Tuổi phải là một số nguyên", Toast.LENGTH_SHORT).show()
            binding.tvKetQua.text = "⚠️ Tuổi không phải là số hợp lệ!"
            return
        }

        // 4. Logic phân loại độ tuổi theo yêu cầu bài tập
        val phanLoai: String
        val chiTietDoTuoi: String

        when (tuoi) {
            in 66..Int.MAX_VALUE -> {
                phanLoai = "Người già"
                chiTietDoTuoi = "(>65)"
            }
            in 6..65 -> {
                phanLoai = "Người lớn"
                chiTietDoTuoi = "(6-65)"
            }
            in 2..5 -> {
                // Đề bài là (2-6). Vì 6 đã được xếp vào "Người lớn" ở điều kiện trên,
                // ta ưu tiên Người lớn (6-65) và giữ nguyên logic 2..5, nhưng ghi chi tiết 2-6
                phanLoai = "Trẻ em"
                chiTietDoTuoi = "(2-6)"
            }
            in 0..1 -> {
                phanLoai = "Em bé"
                chiTietDoTuoi = "(<2)"
            }
            else -> {
                phanLoai = "Không xác định"
                chiTietDoTuoi = ""
            }
        }

        // 5. Định dạng và hiển thị kết quả bằng HTML
        val ketQuaHtml = "Xin chào <b>$hoTen</b> ($tuoi tuổi).<br>" +
                "Bạn được phân loại là: <b>$phanLoai $chiTietDoTuoi</b>."

        // Sử dụng HtmlCompat để hiển thị chữ đậm (<b>...</b>)
        binding.tvKetQua.text = HtmlCompat.fromHtml(ketQuaHtml, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}