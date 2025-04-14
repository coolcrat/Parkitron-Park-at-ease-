package com.example.parkitron

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        val userDetailsText = findViewById<TextView>(R.id.tv_user_details)
        val backToMainBtn = findViewById<Button>(R.id.btn_back_main)

        if (user != null) {
            val info = "Email: ${user.email}\nUID: ${user.uid}"
            userDetailsText.text = info
        } else {
            userDetailsText.text = "User not logged in"
        }

        backToMainBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
