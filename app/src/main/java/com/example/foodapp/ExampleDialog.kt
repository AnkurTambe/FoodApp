package com.example.foodapp

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import kotlin.system.exitProcess

class ExampleDialog : AppCompatDialogFragment() {

    private lateinit var ip: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var ipadd = context?.getSharedPreferences("ip", AppCompatActivity.MODE_PRIVATE)

        val alert = AlertDialog.Builder(requireActivity())

        var inflater = activity?.layoutInflater
        var view = inflater?.inflate(R.layout.layout_dialog, null)


        alert.setView(view)
        alert.setCancelable(false)
        alert.setTitle("IP Address")
        alert.setMessage("Ensure that this device and the PC(hosting WAMP server) are connected to the same WIFI network.\nEnter the IPv4 Address of the corresponding WLAN.\n ")
        ip = view!!.findViewById(R.id.et_ip)
        ip.setText(ipadd?.getString("ipc", ""))
        alert.setPositiveButton(
            "Proceed"
        ) { dialogInterface, i ->

            if (ip.text.isBlank() || ip.text.isEmpty()) {
                Toast.makeText(
                    activity,
                    "Give proper IP, else previous entered IP will be considered.",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                ipadd!!.edit().putString("ipc", ip.text.toString()).apply()
                UserInfo.ip = ipadd?.getString("ipc", "").toString()
            }
            Toast.makeText(activity, UserInfo.ip, Toast.LENGTH_SHORT).show()

        }
        alert.setNegativeButton(
            "Cancel"
        ) { dialogInterface, i ->  }


        return alert.create()
    }
}