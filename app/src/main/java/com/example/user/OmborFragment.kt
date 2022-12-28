package com.example.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.adapter.RV_TotalOmbor
import com.example.user.databinding.FragmentOmborBinding
import com.example.user.model.TotalOmbor

class OmborFragment : Fragment() {
lateinit var binding: FragmentOmborBinding
lateinit var totalOmborList: ArrayList<TotalOmbor>
lateinit var totalOmborAdapter: RV_TotalOmbor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ombor, container, false)
        val binding = FragmentOmborBinding.bind(view)

        loadOmbor()

        totalOmborAdapter = RV_TotalOmbor(requireContext(),totalOmborList)
        binding.rvOmbor.adapter =totalOmborAdapter
        return view
    }

    private fun loadOmbor() {
        totalOmborList =ArrayList()
        for (i in 1 ..17){
            totalOmborList.add(TotalOmbor(i,"ADWQDAD"))
        }
    }


}