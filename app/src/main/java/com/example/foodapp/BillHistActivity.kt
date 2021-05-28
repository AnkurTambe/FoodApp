package com.example.foodapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_bill_hist.*

class BillHistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_hist)

        var url = "http://192.168.0.197/FoodAppPhp/get_bill_his.php?mobileno=${UserInfo.mobile}"
        var list = ArrayList<BillDet>()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            for (x in 0 until response.length()) {

                var p: String = response.getJSONObject(x).getInt("payment").toString()
                var d: String = response.getJSONObject(x).getInt("delivery").toString()
                var pt: String = response.getJSONObject(x).getString("payment_time")

                if (p == "0") {
                    p = "not done"
                    pt = "payment not done"
                } else if (p == "1") {
                    p = "done"
                }

                if (d == "0") {
                    d = "not done"
                } else if (p == "1") {
                    d = "done"
                }

                list.add(
                    BillDet(
                        ((x + 1).toString()),
                        response.getJSONObject(x).getInt("bill_no").toString(),
                        response.getJSONObject(x).getString("bill_date"),
                        p,
                        pt,
                        d
                    )
                )
            }

            var adp = BillAdapter(this, list)
            bill_rv.layoutManager = LinearLayoutManager(this)
            bill_rv.adapter = adp

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })
        rq.add(jar)
    }
}