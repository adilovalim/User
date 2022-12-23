package com.example.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.user.R
import com.example.user.model.DialogUser
import kotlinx.android.synthetic.main.item_one_day.view.*

class DialogAdapter(var user: List<DialogUser>):RecyclerView.Adapter<DialogAdapter.MyViewHolder>() {
    inner class MyViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(user:DialogUser){
            itemView.text_prodact.text = user.maxsulot

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_one_day, parent,false)
        val myViewHolder =MyViewHolder(itemView)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: DialogUser = user[position]
        holder.onBind(user)
    }

    override fun getItemCount(): Int {
        return user.size
    }
}