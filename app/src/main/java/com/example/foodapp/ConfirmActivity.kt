package com.example.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_confirm.*

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        var ty: String? = intent.getStringExtra("t")

        if (ty == "c") {
            pay_tv.text = "COD bitches"
        }

        if (ty == "p") {
            pay_tv.text = "Paypal bitches"
        }
    }
}