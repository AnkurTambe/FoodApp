package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.text.format.Formatter
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide() // hide the title bar
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        ); //enable full screen

        setContentView(R.layout.activity_main)

        var ipadd = getSharedPreferences("ip", AppCompatActivity.MODE_PRIVATE)


        Toast.makeText(
            this,
            "Ensure you have entered proper IP.",
            Toast.LENGTH_SHORT
        ).show()


        var token = getSharedPreferences("mobno", MODE_PRIVATE)

        if (token.getString("logmobno", " ") != " ") {

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        openDialog()

        login_cip.setOnClickListener {
            openDialog()
        }

        login_btn.setOnClickListener {
            if (login_mobile_no.text.toString()
                    .isEmpty() || login_password.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Give Proper Info.", Toast.LENGTH_SHORT).show();
            } else {
                var url = //
                "http://" + UserInfo.ip + "/FoodAppPhp/login.php?mobileno=" + login_mobile_no.text.toString() + "&password=" +
                        login_password.text.toString()

                var rq: RequestQueue = Volley.newRequestQueue(this)
                Toast.makeText(this, "Logging In, Wait......", Toast.LENGTH_SHORT).show()
                var sr = StringRequest(Request.Method.GET, url, { response ->
                    if (response == "0") {
                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    } else {
                        UserInfo.mobile = login_mobile_no.text.toString()
                        Toast.makeText(this, "Logged In!", Toast.LENGTH_SHORT).show()

                        var i = Intent(this, HomeActivity::class.java)
                        i.putExtra("mobno", UserInfo.mobile)
                        finish()

                        var editor = token.edit()
                        editor.putString("logmobno", UserInfo.mobile)
                        editor.apply()

                        startActivity(i)
                    }
                }, { error ->
                    Toast.makeText(
                        this,
                        "Error:" + error.message + " Log In Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                })


                rq.add(sr)
            }
        }

        login_signup.setOnClickListener {
            var i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }

    private fun openDialog() {
        var exampleDialog = ExampleDialog()
        exampleDialog.isCancelable = false
        exampleDialog.show(supportFragmentManager, "example dialog")
    }

    override fun onBackPressed() {

        val alert = AlertDialog.Builder(this)

        alert.setCancelable(false)
        alert.setTitle("Alert")
        alert.setMessage("Want to Exit?")

        alert.setPositiveButton(
            "No"
        ) { dialogInterface, i -> }
        alert.setNegativeButton(
            "Exit"
        ) { dialogInterface, i -> exitProcess(0) }

        alert.show()

    }
}
