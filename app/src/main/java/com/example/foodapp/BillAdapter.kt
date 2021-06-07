package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bill_project.view.*

class BillAdapter(var context: Context, var list: ArrayList<BillDet>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.bill_project, parent, false)
        return ItemHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(
            list[position].srno,
            list[position].billid,
            list[position].billcredate,
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(s: String, b: String, bd: String) {

            itemView.srno1.text = s
            itemView.billid1.text = b
            itemView.billcredate1.text = bd

            itemView.bill_cv.setOnClickListener {

                var i = Intent(itemView.context, BillDetActivity::class.java)
                i.putExtra("b", b)
                itemView.context.startActivity(i)

            }
        }
    }
}