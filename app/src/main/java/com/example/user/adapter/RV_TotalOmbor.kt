package com.example.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.user.R
import com.example.user.model.TotalOmbor
import kotlinx.android.synthetic.main.item_for_ombor.view.*

class RV_TotalOmbor(var context: android.content.Context, var totalOmbor: List<TotalOmbor>):RecyclerView.Adapter<RV_TotalOmbor.MyViewHolder>(){
    inner class MyViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(totalOmbor: TotalOmbor){
            itemView.ombor_name.text = totalOmbor.totalProdact


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_for_ombor, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val totalOmbor: TotalOmbor =totalOmbor[position]
        holder.onBind(totalOmbor)
    }

    override fun getItemCount(): Int {
        return totalOmbor.size
    }
}