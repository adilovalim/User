package com.example.user

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.user.databinding.Dialog1Binding
import com.example.user.databinding.FragmentAddBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.io.FileOutputStream

class AddFragment : Fragment() {
    val REQUEST_CODE = 1
lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        var binding = FragmentAddBinding.bind(view)

//        Dexter.withContext(requireContext())
//            .withPermissions(
//                Manifest.permission.CAMERA,
//                Manifest.permission.READ_EXTERNAL_STORAGE,
//            ).withListener(object : MultiplePermissionsListener {
//                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
//
//                }
//
//                override fun onPermissionRationaleShouldBeShown(
//                    permissions: List<PermissionRequest?>?,
//                    token: PermissionToken?
//                ) { /* ... */
//                }
//            }).check()
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
            bind.immage1.setOnClickListener {
//                pickImageFromNewGallarey()
                clickPeremision()
            }
        }

//        binding.radioBtn.setOnClickListener {
//            binding.productSoni.visibility = View.INVISIBLE
//            Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
//        }
        return view
    }

    private fun clickPeremision() {
        val intent = Intent(requireContext(), PeremissionActivity::class.java)
        startActivity(intent)
    }

//    private fun pickImageFromNewGallarey() {
//        getImageContent.launch("image/*")
//    }
//    private val getImageContent =registerForActivityResult(ActivityResultContracts.GetContent()){ uri ->
//        uri?: return@registerForActivityResult
//        binding.gallareyImage.setImageURI(uri)
//        val openInputStream = requireActivity().contentResolver?.openInputStream(uri)
//        val file = requireActivity().File.(filesDir, "image.jpg")
//        val fileOutputStream = requireActivity()FileOutputStream(file)
//        openInputStream?.copyTo(fileOutputStream)
//        openInputStream?.close()
//        fileOutputStream.close()
//        val fileAbsolutePath = file.absolutePath
//        Toast.makeText(requireContext(), fileAbsolutePath, Toast.LENGTH_SHORT).show()
//    }

}