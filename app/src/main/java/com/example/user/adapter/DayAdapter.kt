package com.example.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.user.R
import com.example.user.model.Prodact
import kotlinx.android.synthetic.main.item_prodact.view.*

class DayAdapter (var prodactList: List<Prodact>): RecyclerView.Adapter<DayAdapter.MyViewHolder>(){

    inner class MyViewHolder(var itemView: View ):RecyclerView.ViewHolder(itemView){
        fun onBind(prodact: Prodact){
            itemView.prodact_name.text = prodact.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.item_prodact, parent,false)
        val myViewHolder =MyViewHolder(itemView)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val prodact:Prodact =prodactList[position]
        holder.onBind(prodact)
    }

    override fun getItemCount(): Int {
        return prodactList.size

    }
}