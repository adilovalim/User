package com.example.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.user.adapter.DayAdapter
import com.example.user.databinding.FragmentHomeBinding
import com.example.user.model.Prodact

class HomeFragment : Fragment() {
  lateinit var prodactList: ArrayList<Prodact>
  lateinit var prodactAdapter: DayAdapter
  lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding iwlatin
        //aga ok kegn bottom nav no tori iwlavoti
        // bilvoman bittada iwlomayapti\
        // bosilgandan kegn iwladi
        // bottom navdigi home icon
        // bottom navi qarab ciqin qatida xato borligini
        // boldimi any deski ocirvurimi
        //da boladi hozi design i bn bottomi qarvoqaman
        // aga
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        addProdact()
        prodactAdapter = DayAdapter(requireContext(),prodactList)
        binding.rvOneDAy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOneDAy.adapter = prodactAdapter



        return view
    }

    private fun addProdact() {
        prodactList = ArrayList()
        for (i in 1..100){
            prodactList.add(Prodact(i,"apple"))
        }
    }

}