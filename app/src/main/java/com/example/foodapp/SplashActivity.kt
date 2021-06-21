package com.example.foodapp


import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.format.Formatter
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

//        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        val ipa: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        if (token.getString("logmobno", " ") != " ") {
            Handler(Looper.getMainLooper()).postDelayed({
                openDialog()
            }, 3000)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }


    }

    private fun openDialog() {
        var exampleDialog = ExampleDialog()
        exampleDialog.isCancelable = false
        exampleDialog.show(supportFragmentManager, "example dialog")
    }
}