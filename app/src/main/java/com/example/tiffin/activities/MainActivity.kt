package com.example.tiffin.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tiffin.R
import com.example.tiffin.utils.UserDataProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var context: Context
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        val userDataProvider = UserDataProvider(context)

        val user = userDataProvider.getUser()

        val details = "Name: ${user.name}\nPhone: ${user.phone}\nEmail; ${user.email} "

        tvName.text = details

        btnLogout.setOnClickListener {
            userDataProvider.logout()
            startActivity(Intent(context, LoginActivity::class.java))
            finish()
        }

    }

}