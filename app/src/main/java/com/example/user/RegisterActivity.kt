package com.example.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.user.databinding.ActivityRegisterBinding
import com.example.user.model.User
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView) ?: return
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())

        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btn.setOnClickListener {
            val intent = Intent(this, VerificationActivity::class.java)
            val name = binding.userName.text.toString()
            val number = binding.phoneNumber.text.toString()
            if (name.isNotBlank() && number.isNotBlank()) {
                val user = User(name = name, phoneNumber = number)
                intent.putExtra("user", user)

                startActivity(intent)
            } else {
                Toast.makeText(this, "ma'lumot kiritilmagan", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}