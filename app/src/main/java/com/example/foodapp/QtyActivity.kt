package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_qty.*

class QtyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qty)


        var url = "http://" + UserInfo.ip + "/FoodAppPhp/get_dialog_item.php?id=${UserInfo.itemid}"

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            d_title.text = response.getJSONObject(0).getString("name")
            d_price.text = "$ " + response.getJSONObject(0).getString("price")
            val u = response.getJSONObject(0).getString("photo")

            var web: String = "http://" + UserInfo.ip + "/FoodAppPhp/images/$u"
            web = web.replace(" ", "%20")
            Picasso.get().load(web).into(d_item_image)

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })

        rq.add(jar)

        add_btn.setOnClickListener {

            if (et_qty.text.isEmpty() || et_qty.text.toString() == "0") {
                Toast.makeText(this, "Enter Proper Value", Toast.LENGTH_SHORT).show()
            } else {
                var url =
                    "http://" + UserInfo.ip + "/FoodAppPhp/add_temp.php?mobile=" + UserInfo.mobile + "&itemid=" + UserInfo.itemid +
                            "&qty=" + et_qty.text.toString()

                var rq: RequestQueue = Volley.newRequestQueue(this)
                var sr = StringRequest(Request.Method.GET, url, { response ->

                    var i = Intent(this, OrderActivity::class.java)
                    startActivity(i)

                }, { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })

                rq.add(sr)
            }

        }

        cancel_btn.setOnClickListener {
            var i = Intent(this, HomeActivity::class.java)
            startActivity(i)

        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}