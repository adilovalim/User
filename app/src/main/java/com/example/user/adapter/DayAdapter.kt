package com.example.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.user.R
import com.example.user.model.DialogProdact
import kotlinx.android.synthetic.main.item_prodact.view.*

class DayAdapter(var prodactList: List<DialogProdact>, var onMyItemClickListener: OnMyItemClickListener): RecyclerView.Adapter<DayAdapter.MyViewHolder>(){

    inner class MyViewHolder(var itemView: View ):RecyclerView.ViewHolder(itemView){
        fun onBind(prodact: DialogProdact){
            itemView.prodact_name.text = prodact.name
            itemView.setOnClickListener {
                onMyItemClickListener.onMyItemClick(prodact)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.item_prodact, parent,false)
        val myViewHolder =MyViewHolder(itemView)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val prodact:DialogProdact =prodactList[position]
        holder.onBind(prodact)
    }

    override fun getItemCount(): Int {
        return prodactList.size

    }

    interface OnMyItemClickListener{
        fun onMyItemClick(prodact: DialogProdact)
    }



}