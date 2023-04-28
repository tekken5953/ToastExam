package com.example.toastexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.airsignal_app.view.ToastUtilsKotlin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stackBtn: Button = findViewById(R.id.stackToastBtn)
        val refreshBtn: Button = findViewById(R.id.refreshToastBtn)
        var countStack = 1
        var countRefresh = 1

        val toast = ToastUtilsKotlin(this)

        stackBtn.setOnClickListener {
            Toast.makeText(this, "토스트 메시지 스택 $countStack", Toast.LENGTH_SHORT).show()
            countStack++
        }

        refreshBtn.setOnClickListener {
            toast.showMessage("토스트 메시지 갱신 $countRefresh",1)
            countRefresh++
        }
    }
}