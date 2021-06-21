package com.example.foodapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_bill_det.*

class BillDetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_det)

        var billno: String? = intent.getStringExtra("b")

        bill_id.text = billno
        var tot: String? = ""


        var url1 = "http://" + UserInfo.ip + "/FoodAppPhp/get_total.php?bill_no=$billno"
        var rq1: RequestQueue = Volley.newRequestQueue(this)
        var sr1 = StringRequest(Request.Method.GET, url1, { response ->

            tot = response

            bill_total.text = "$ $tot"
        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })
        rq1.add(sr1)


        var url = "http://" + UserInfo.ip + "/FoodAppPhp/get_bill.php?bill_no=$billno"

        var list = ArrayList<String>()
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null, { response ->

            for (x in 0 until response.length())
                list.add(
                    "Name : " + response.getJSONObject(x).getString("name") + "\n" +
                            "Price : $" + response.getJSONObject(x).getString("price")
                            + "\n" + "Qty : " + response.getJSONObject(x).getString("qty")
                )

            var adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
            order_lv.adapter = adp

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        })
        rq.add(jar)
    }
}