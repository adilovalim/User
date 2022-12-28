package com.example.user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.user.databinding.FragmentSettingsBinding
import com.example.user.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SettingsFragment : Fragment() {
    lateinit var binding: FragmentSettingsBinding
    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    lateinit var myRef: DatabaseReference
    lateinit var currentUser: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        database = Firebase.database
        myRef = database.getReference("users")
        val user = auth.currentUser!!
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach {
                    if (user.uid == it.getValue(User::class.java)?.id) {
                        currentUser = it.getValue(User::class.java)!!
                        binding.user.text = currentUser.name
                        binding.number.text = currentUser.phoneNumber
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("AAA", "onCancelled: ${error.message}")
            }

        })
        binding.firbase.setOnClickListener{
            findNavController().navigate(R.id.firebaseFragment)
        }

        binding.ombor.setOnClickListener {
            findNavController().navigate(R.id.omborFragment)
        }
        return view
    }

}