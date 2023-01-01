package com.example.user

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.user.adapter.DayAdapter
import com.example.user.adapter.RV_Dialog
import com.example.user.databinding.DialogTabBinding
import com.example.user.databinding.FragmentHomeBinding
import com.example.user.model.DialogMaterial
import com.example.user.model.DialogProdact

class HomeFragment : Fragment() {
  lateinit var prodactList: ArrayList<DialogProdact>
  lateinit var prodactAdapter: DayAdapter
  lateinit var dialogList:ArrayList<DialogMaterial>
  lateinit var dialogAdater:RV_Dialog
  lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        addProdact()
        prodactAdapter =DayAdapter(prodactList, object :DayAdapter.OnMyItemClickListener{
            override fun onMyItemClick(prodact: DialogProdact) {
                val aler = AlertDialog.Builder(requireContext()).create()
                val tage = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_tab, binding.root, false)
                aler.setView(tage)
                aler.show()
                aler.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                val itemclick = DialogTabBinding.bind(tage)
                addDialog()
                dialogAdater = RV_Dialog(dialogList,object :RV_Dialog.OnMyItemClickListener{
                    override fun onMyItemLongClick(dialogMaterial: DialogMaterial) {
                        Toast.makeText(requireContext(), "Add qilingan", Toast.LENGTH_SHORT).show()
                    }

                })
                itemclick.dialogRv.adapter = dialogAdater


            }

            private fun addDialog() {
                dialogList =ArrayList()
                for (i in 1..5){
                    dialogList.add(DialogMaterial(i,"Sotildi$i","17$i"))
                }
            }

        })
        binding.rvOneDAy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOneDAy.adapter = prodactAdapter



        return view
    }

    private fun addProdact() {
        prodactList = ArrayList()
        for (i in 1..100){
            prodactList.add(DialogProdact(i,"Falonchiga "))
        }
    }

}