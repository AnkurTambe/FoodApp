package com.example.foodapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_project_2.view.*

class ItemAdapter1(var context: Context, var list: ArrayList<temp_item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.item_project_2, parent, false)
        return ItemHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(
            list[position].name,
            list[position].price,
            list[position].photo,
            list[position].id,
            list[position].qty
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(n: String, p: Double, u: String, i: Int, q: Int) {
            itemView.title2.text = n
            itemView.price2.text = "$ ${p.toString()}"
            itemView.qty2.text = "Qty: ${q.toString()}"
            var web: String = "http://192.168.0.197/FoodAppPhp/images/$u"
            web = web.replace(" ", "%20")
            Picasso.get().load(web).into(itemView.item_image2)

        }
    }
}