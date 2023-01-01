package com.example.user

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.example.user.databinding.ActivityPeremissionBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class PeremissionActivity : AppCompatActivity() {
    lateinit var currentPhotoPath: String
    lateinit var photoUri: Uri
    val REQUEST_CODE = 1

    lateinit var binding : ActivityPeremissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeremissionBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.immage2.setOnClickListener {
            getImageFromCameraNewVersion()
        }
        binding.immage1.setOnClickListener {
            pickImageFromNewGallarey()
        }
        binding.btnSave.setOnClickListener {
            Toast.makeText(this, "_________<>!", Toast.LENGTH_SHORT).show()
            finish()
        }



    }

    private fun getImageFromCameraNewVersion() {
        val imageFile = createImageFile()
        photoUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, imageFile)
        getTakeImageContent.launch(photoUri)
    }
    private var getTakeImageContent =
        registerForActivityResult(ActivityResultContracts.TakePicture()) {
            if (it) {
                binding.gallareyImage.setImageURI(photoUri)
            }
        }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        //...../JPEG_13.08.2022.jpg
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath = absolutePath
        }
    }

    private fun requestPermissions() {
        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(multiplePermissionsReport: MultiplePermissionsReport) {
                    if (multiplePermissionsReport.areAllPermissionsGranted()) {
                        Toast.makeText(
                            this@PeremissionActivity,
                            "All the permissions are granted..",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied) {
                        showSettingsDialog()
                    }
                }
                override fun onPermissionRationaleShouldBeShown(
                    list: List<PermissionRequest>,
                    permissionToken: PermissionToken
                ) {
                    permissionToken.continuePermissionRequest()
                }
            }).withErrorListener {
                Toast.makeText(applicationContext, "Error occurred! ", Toast.LENGTH_SHORT).show()
            }
            .onSameThread().check()
    }


    private fun showSettingsDialog() {
        val builder = AlertDialog.Builder(this@PeremissionActivity)
        builder.setTitle("Need Permissions")
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.")
        builder.setPositiveButton(
            "GOTO SETTINGS"
        ) { dialog, which ->
            dialog.cancel()
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivityForResult(intent, 101)
        }
        builder.setNegativeButton(
            "Cancel"
        ) { dialog, which ->
            dialog.cancel()
        }
        builder.show()
    }

    private fun pickImageFromNewGallarey() {
        getImageContent.launch("image/*")
    }
    private val getImageContent =registerForActivityResult(ActivityResultContracts.GetContent()){ uri:Uri? ->
        uri?: return@registerForActivityResult
        binding.gallareyImage.setImageURI(uri)
        val openInputStream = contentResolver?.openInputStream(uri)
        val file = File(filesDir, "image.jpg")
        val fileOutputStream = FileOutputStream(file)
        openInputStream?.copyTo(fileOutputStream)
        openInputStream?.close()
        fileOutputStream.close()
        val fileAbsolutePath = file.absolutePath
        Toast.makeText(this, fileAbsolutePath, Toast.LENGTH_SHORT).show()
    }
}