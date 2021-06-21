package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cat: String? = intent.getStringExtra("cat")
        title = "$cat Menu"
        setContentView(R.layout.activity_item)


        var url = "http://" + UserInfo.ip + "/FoodAppPhp/get_items.php?category=$cat"
        var list1 = ArrayList<Item>()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            for (x in 0 until response.length())
                list1.add(
                    Item(
                        response.getJSONObject(x).getInt("id"),
                        response.getJSONObject(x).getString("name"),
                        response.getJSONObject(x).getDouble("price"),
                        response.getJSONObject(x).getString("photo")
                    )
                )

            var adp = ItemAdapter(this, list1)
            item_rv.layoutManager = LinearLayoutManager(this)
            item_rv.adapter = adp

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })

        rq.add(jar)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tools, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.userinfo) {
            Toast.makeText(this, "Your Profile", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        if (item.itemId == R.id.cart) {
            Toast.makeText(this, "Your Cart", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, OrderActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
