package com.example.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.user.R
import com.example.user.model.DialogMaterial
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.item_for_dialog_rv.view.*
import kotlinx.android.synthetic.main.item_prodact.view.*

class RV_Dialog(var dialogMaterial:List<DialogMaterial>, var onMyItemClickListener: OnMyItemClickListener):RecyclerView.Adapter<RV_Dialog.MyViewHolder>() {
    inner class MyViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(dialogMaterial:DialogMaterial){
            itemView.tv_text_count_dialog.text= dialogMaterial.count
            itemView.tv_text_dialog.text = dialogMaterial.name
            onMyItemClickListener.onMyItemLongClick(dialogMaterial)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_for_dialog_rv, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val diaogMaterial:DialogMaterial = dialogMaterial[position]
        holder.onBind(diaogMaterial)
    }

    override fun getItemCount(): Int {
        return dialogMaterial.size
    }

    interface OnMyItemClickListener{
        fun onMyItemLongClick(dialogMaterial: DialogMaterial)
    }
}