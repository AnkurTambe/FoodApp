package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pay.*

class PayActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        var type: String? = ""
        var t: String? = intent.getStringExtra("t")

        main_total.text = "$ $t"

        btn_paytm.setOnClickListener {
            type = "pt"
            var i = Intent(this, ConfirmActivity::class.java)
            i.putExtra("t", type)
            i.putExtra("b", t)
            startActivity(i)
        }

        btn_paypal.setOnClickListener {
            type = "pp"
            var i = Intent(this, ConfirmActivity::class.java)
            i.putExtra("t", type)
            i.putExtra("b", t)
            startActivity(i)
        }

        btn_cancel_trans.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setCancelable(false)
            alert.setTitle("Alert")
            alert.setMessage("Do you want to Cancel the Transaction?")
            alert.setPositiveButton(
                "Yes"
            ) { dialogInterface, i -> startActivity(Intent(this, HomeActivity::class.java)) }
            alert.setNegativeButton(
                "No"
            ) { dialogInterface, i -> }
            alert.show()
        }
    }

    override fun onBackPressed() {
        val alert = AlertDialog.Builder(this)
        alert.setCancelable(false)
        alert.setTitle("Alert")
        alert.setMessage("Do you want to Cancel the Transaction?")
        alert.setPositiveButton(
            "Yes"
        ) { dialogInterface, i -> startActivity(Intent(this, HomeActivity::class.java)) }
        alert.setNegativeButton(
            "No"
        ) { dialogInterface, i -> }
        alert.show()
    }
}