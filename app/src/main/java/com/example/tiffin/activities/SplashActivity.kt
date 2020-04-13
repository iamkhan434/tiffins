package com.example.tiffin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.tiffin.R
import com.example.tiffin.utils.UserDataProvider

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userDataProvider = UserDataProvider(this)

        val phone = userDataProvider.getPhone()
        val password = userDataProvider.getPassword()

        val intent = if (phone.isNotEmpty() && password.isNotEmpty()) {
            Intent(this, MainActivity::class.java)
        }else {
            Intent(this, LoginActivity::class.java)
        }

        val handler = Handler()

        handler.postDelayed(
                {
                    startActivity(intent)
                    finish()

                }, 1500
        )

    }




}