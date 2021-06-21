package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_project.view.*

class ItemAdapter(var context: Context, var list: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.item_project, parent, false)
        return ItemHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(
            list[position].name,
            list[position].price,
            list[position].photo,
            list[position].id
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(n: String, p: Double, u: String, i: Int) {
            itemView.title.text = n
            itemView.price.text = "$ ${p.toString()}"
            var web: String = "http://" + UserInfo.ip + "/FoodAppPhp/images/$u"
            web = web.replace(" ", "%20")
            Picasso.get().load(web).into(itemView.item_image)

            itemView.img_add_cart.setOnClickListener {

                UserInfo.itemid = i

                var i = Intent(itemView.context, QtyActivity::class.java)
                itemView.context.startActivity(i)

            }
        }
    }
}