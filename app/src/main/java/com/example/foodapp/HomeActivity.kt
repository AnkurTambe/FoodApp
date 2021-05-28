package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var token = getSharedPreferences("mobno", Context.MODE_PRIVATE)

        UserInfo.mobile = token.getString("logmobno", " ")!!

        card_pizza.setOnClickListener {
            var cat: String = "Pizza"
            var obj = Intent(this, ItemActivity::class.java)
            obj.putExtra("cat", cat)
            startActivity(obj)
        }

        card_sandwich.setOnClickListener {
            var cat: String = "Sandwich"
            var obj = Intent(this, ItemActivity::class.java)
            obj.putExtra("cat", cat)
            startActivity(obj)
        }

        card_salad.setOnClickListener {
            var cat: String = "Salad"
            var obj = Intent(this, ItemActivity::class.java)
            obj.putExtra("cat", cat)
            startActivity(obj)
        }

        card_beverages.setOnClickListener {
            var cat: String = "Beverages"
            var obj = Intent(this, ItemActivity::class.java)
            obj.putExtra("cat", cat)
            startActivity(obj)
        }

        card_extra.setOnClickListener {
            var cat: String = "Extra"
            var obj = Intent(this, ItemActivity::class.java)
            obj.putExtra("cat", cat)
            startActivity(obj)
        }
    }

    override fun onBackPressed() {

        val alert = AlertDialog.Builder(this)
        alert.setCancelable(false)
        alert.setTitle("Alert")
        alert.setMessage("Do you want to Quit the app?")
        alert.setPositiveButton(
            "Yes"
        ) { dialogInterface, i ->
            this.finish();
            System.exit(0);
        }
        alert.setNegativeButton(
            "No"
        ) { dialogInterface, i -> }
        val alertDialog: AlertDialog = alert.create()
        alert.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tools, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.userinfo) {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        if (item.itemId == R.id.cart) {
            startActivity(Intent(this, OrderActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}