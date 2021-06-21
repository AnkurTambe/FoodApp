package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var url = "http://" + UserInfo.ip + "/FoodAppPhp/get_temp.php?mobileno=${UserInfo.mobile}"
        var list = ArrayList<temp_item>()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            for (x in 0 until response.length())
                list.add(
                    temp_item(
                        response.getJSONObject(x).getInt("id"),
                        response.getJSONObject(x).getString("name"),
                        response.getJSONObject(x).getDouble("price"),
                        response.getJSONObject(x).getString("photo"),
                        response.getJSONObject(x).getInt("qty")
                    )
                )

            var adp2 = ItemAdapter1(this, list)
            item_rv2.layoutManager = LinearLayoutManager(this)
            item_rv2.adapter = adp2

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })
        rq.add(jar)

        btn_menu.setOnClickListener {
            var i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

        btn_confirm.setOnClickListener {

            if (list.isEmpty()) {
                Toast.makeText(this, "Cart is Empty", Toast.LENGTH_SHORT).show()
            } else {

                var url =
                    "http://" + UserInfo.ip + "/FoodAppPhp/confirm_order.php?mobileno=" + UserInfo.mobile
                var rq: RequestQueue = Volley.newRequestQueue(this)
                var sr = StringRequest(Request.Method.GET, url, { response ->

                    Toast.makeText(this, "Items shifted from Cart to Bill list", Toast.LENGTH_SHORT)
                        .show()

                    var i = Intent(this, BillActivity::class.java)
                    i.putExtra("bno", response)
                    startActivity(i)

                }, { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })

                rq.add(sr)
            }

        }

        btn_cancel.setOnClickListener {
            if (list.isEmpty()) {
                Toast.makeText(this, "Cart is Empty", Toast.LENGTH_SHORT).show()
            } else {

                var url =
                    "http://" + UserInfo.ip + "/FoodAppPhp/cancel_order.php?mobileno=" + UserInfo.mobile

                var rq: RequestQueue = Volley.newRequestQueue(this)
                var sr = StringRequest(Request.Method.GET, url, { response ->

                    Toast.makeText(this, "Cart Emptied!", Toast.LENGTH_SHORT)
                        .show()

                    var i = Intent(this, OrderActivity::class.java)
                    startActivity(i)

                }, { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })

                rq.add(sr)
            }

        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}
