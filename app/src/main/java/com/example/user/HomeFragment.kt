package com.example.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.user.adapter.DayAdapter
import com.example.user.adapter.DialogAdapter
import com.example.user.databinding.FragmentHomeBinding
import com.example.user.model.DialogUser
import com.example.user.model.Prodact

class HomeFragment : Fragment() {
  lateinit var prodactList: ArrayList<Prodact>
  lateinit var prodactAdapter: DayAdapter
  lateinit var binding:FragmentHomeBinding
  lateinit var dialogList: ArrayList<DialogUser>
  lateinit var dialogAd:DialogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        addProdact()
        prodactAdapter = DayAdapter(requireContext(),prodactList)
        binding.rvOneDAy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOneDAy.adapter = prodactAdapter



        addDialog()

        dialogAd = DialogAdapter(dialogList)
        binding// wetta topomayapti
        return view
    }

    private fun addDialog() {
        dialogList = ArrayList()
        for (i in 1..7){
            dialogList.add(DialogUser(i, "Olma $$i", false))
        }
    }

    private fun addProdact() {
        prodactList = ArrayList()
        for (i in 1..100){
            prodactList.add(Prodact(i,"apple"))
        }
    }

}