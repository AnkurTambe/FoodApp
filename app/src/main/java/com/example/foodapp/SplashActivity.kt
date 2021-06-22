package com.example.foodapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlin.system.exitProcess

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide() // hide the title bar
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        ); //enable full screen

        setContentView(R.layout.activity_splash)

        var token = getSharedPreferences("mobno", MODE_PRIVATE)
        var ipadd = getSharedPreferences("ip", AppCompatActivity.MODE_PRIVATE)


//        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        val ipa: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        Handler(Looper.getMainLooper()).postDelayed({
            splash.visibility = View.INVISIBLE
            dialog.visibility = View.VISIBLE

            et1.setText(ipadd?.getString("ipc", ""))

            b1.setOnClickListener {
                if (et1.text.isBlank() || et1.text.isEmpty()) {
                    et1.error = "Give Proper IP"
                } else {
                    ipadd!!.edit().putString("ipc", et1.text.toString()).apply()
                    UserInfo.ip = ipadd.getString("ipc", "").toString()

                    Toast.makeText(this, UserInfo.ip, Toast.LENGTH_SHORT).show()
                }
                if (token.getString("logmobno", " ") != " ") {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            b2.setOnClickListener {
                exitProcess(0)
            }

        }, 3000)
    }

}