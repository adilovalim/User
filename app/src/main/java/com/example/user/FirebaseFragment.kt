package com.example.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.databinding.FragmentFirebaseBinding
import kotlinx.android.synthetic.main.fragment_firebase.*

class FirebaseFragment : Fragment() {
lateinit var binding: FragmentFirebaseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_firebase, container, false)
        val binding = FragmentFirebaseBinding.bind(view)
        binding.webView.settings.javaScriptEnabled =true
        val uri = "https://www.youtube.com/"
        binding.webView.loadUrl(uri)



        return view
    }

}