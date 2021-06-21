package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_profile.*
import kotlin.system.exitProcess

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var token = getSharedPreferences("mobno", Context.MODE_PRIVATE)


        var url = "http://192.168.0.197/FoodAppPhp/get_profile.php?mobileno=${UserInfo.mobile}"

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            username1.text = response.getJSONObject(0).getString("name")
            mob1.text = response.getJSONObject(0).getString("mobileno")
            address1.text = response.getJSONObject(0).getString("address")

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })

        rq.add(jar)

        logoutbtn.setOnClickListener {

            val alert = AlertDialog.Builder(this)
            alert.setCancelable(false)
            alert.setTitle("LogOut!")
            alert.setMessage("Do you want to logout?")
            alert.setPositiveButton(
                "Yes"
            ) { dialogInterface, i ->
                var editor = token.edit()
                editor.putString("logmobno", " ")
                editor.apply()

                Toast.makeText(this, "Logged Out!", Toast.LENGTH_SHORT).show()

                var i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }
            alert.setNegativeButton(
                "No"
            ) { dialogInterface, i -> }

            alert.show()
        }

        bill_his_btn.setOnClickListener {

            startActivity(Intent(this, BillHistActivity::class.java))

        }
    }
}