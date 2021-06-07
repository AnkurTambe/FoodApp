package com.example.foodapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_confirm.*

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        var type: String = ""

        var ty: String? = intent.getStringExtra("t")
        var bi: String? = intent.getStringExtra("b")

        if (ty == "pt") {
            type = "Paytm"
        }

        if (ty == "pp") {
            type = "Paypal"
        }

        val notificationId = 1;
        val channelId = "personal_notification"
        val notificationBulider = NotificationCompat.Builder(this, channelId)
        notificationBulider.setSmallIcon(R.drawable.fa_icon_circle)
        notificationBulider.setContentTitle("Order Placed")
        notificationBulider.setContentText("Your order has been successfully placed!")
        notificationBulider.setStyle(
            NotificationCompat.BigTextStyle()
                .bigText("Ordered from FoodApp, amounting to Rs.$bi ($type)")
        )
        notificationBulider.priority = NotificationCompat.PRIORITY_DEFAULT

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(notificationId, notificationBulider.build())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)//less than oreo
        {
            val name = "Order Placed"
            val description = "Your order has been successfully placed!"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val notificationChannel = NotificationChannel(channelId, name, importance)

            notificationChannel.description = description

            val notificationManager =
                (getSystemService(Context.NOTIFICATION_SERVICE)) as NotificationManager

            notificationManager.createNotificationChannel(notificationChannel)
            notificationManager.notify(1, notificationBulider.build())
        }

        buttonOkay.setOnClickListener {
            var obj = Intent(this, HomeActivity::class.java)
            startActivity(obj)
        }
    }

    override fun onBackPressed() {
        var obj = Intent(this, HomeActivity::class.java)
        startActivity(obj)
    }
}