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
import com.example.user.databinding.Dialog1Binding
import com.example.user.databinding.FragmentAddBinding

class AddFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        var binding = FragmentAddBinding.bind(view)

        binding.foto.setOnClickListener {
            val alert = AlertDialog.Builder(context).create()

            val view1 = LayoutInflater.from(context).inflate(R.layout.dialog_1, binding.root, false)
            alert.setView(view1)
            alert.show()

            alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val bind = Dialog1Binding.bind(view1)

            bind.btnSave.setOnClickListener {

                alert.dismiss()
                Toast.makeText(context, "SUCCESSFULLY", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }


}