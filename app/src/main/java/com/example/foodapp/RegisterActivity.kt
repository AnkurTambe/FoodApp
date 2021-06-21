package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        Toast.makeText(
            this,
            "Ensure you have entered proper IP.",
            Toast.LENGTH_SHORT
        ).show()

        openDialog()

        reg_cip.setOnClickListener {
            openDialog()

        }

        signup_btn.setOnClickListener {

            if (reg_mobile_no.text.toString()
                    .isEmpty() || reg_password.text.toString()
                    .isEmpty() || reg_name.text.toString()
                    .isEmpty() || reg_address.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Give Proper Info", Toast.LENGTH_SHORT).show()
            } else {
                if (reg_password.text.toString() == reg_confirm_password.text.toString()) {
                    var url =
                        "http://" + UserInfo.ip + "/FoodAppPhp/add_user.php?mobileno=" + reg_mobile_no.text.toString() + "&password=" +
                                reg_password.text.toString() + "&name=" + reg_name.text.toString() + "&address=" + reg_address.text.toString()

                    var rq: RequestQueue = Volley.newRequestQueue(this)
                    var sr = StringRequest(Request.Method.GET, url, { response ->
                        if (response == "0")
                            Toast.makeText(this, "Mobile no. already used", Toast.LENGTH_SHORT)
                                .show()
                        else {
                            Toast.makeText(this, "Signed Up", Toast.LENGTH_SHORT).show()
                            val i = Intent(this, MainActivity::class.java)
                            startActivity(i)
                        }

                    }, { error ->
                        Toast.makeText(this, error.message + "Sign Up Failed", Toast.LENGTH_SHORT)
                            .show()
                    })

                    rq.add(sr)
                } else
                    Toast.makeText(this, "Passwords don't not match", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openDialog() {
        var exampleDialog = ExampleDialog()
        exampleDialog.isCancelable = false
        exampleDialog.show(supportFragmentManager, "example dialog")
    }

    override fun onBackPressed() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
}
