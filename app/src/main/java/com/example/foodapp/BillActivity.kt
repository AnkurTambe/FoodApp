package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_bill.*

class BillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)
        var billno: String? = intent.getStringExtra("bno")
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

        btn_proceed.setOnClickListener {
            var i = Intent(this, PayActivity::class.java)
            i.putExtra("bill_no", billno)
            i.putExtra("t", tot)
            startActivity(i)
        }



        btn_cancel.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setCancelable(false)
            alert.setTitle("Do you want to Cancel the Order?")
            alert.setMessage("If you press 'Yes', then your Order will be cancelled.")
            alert.setPositiveButton(
                "Yes"
            ) { dialogInterface, i -> startActivity(Intent(this, HomeActivity::class.java)) }
            alert.setNegativeButton(
                "No"
            ) { dialogInterface, i -> }
            val alertDialog: AlertDialog = alert.create()
            alert.show()
        }
    }

    override fun onBackPressed() {
        val alert = AlertDialog.Builder(this)
        alert.setCancelable(false)
        alert.setTitle("Do you want to Cancel the Order?")
        alert.setMessage("If you press 'Yes', then your Order will be cancelled.")
        alert.setPositiveButton(
            "Yes"
        ) { dialogInterface, i -> startActivity(Intent(this, HomeActivity::class.java)) }
        alert.setNegativeButton(
            "No"
        ) { dialogInterface, i -> }
        val alertDialog: AlertDialog = alert.create()
        alert.show()
    }
}