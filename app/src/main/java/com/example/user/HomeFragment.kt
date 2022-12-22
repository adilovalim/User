package com.example.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.user.adapter.DayAdapter
import com.example.user.model.Prodact
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
  lateinit var prodactList: ArrayList<Prodact>
  lateinit var prodactAdapter: DayAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        addProdact()
        prodactAdapter = DayAdapter(prodactList)
        rv_oneDAy.layoutManager = LinearLayoutManager(requireContext())
        rv_oneDAy.adapter = prodactAdapter
        return view
    }

    private fun addProdact() {
        prodactList = ArrayList()
        for (i in 1..100){
            prodactList.add(Prodact(i,"apple", "123 $i"))
        }
    }

}