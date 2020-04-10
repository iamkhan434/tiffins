package com.example.tiffin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tiffin.R
import com.example.tiffin.utils.UserDataProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        context = this@LoginActivity

        btnLogin.setOnClickListener {

            val phone = etPhone.text.toString()

            if (phone.length != 10 ) {
                mfPhone.error = "Enter 10 digit mobile number"
                return@setOnClickListener
            }

            val password = etPassword.text.toString()

            if (password.length < 4) {

                mfPassword.error = "Enter valid password"
                return@setOnClickListener
            }

            val userDataProvider = UserDataProvider(context)

            val myPhone = userDataProvider.getPhone()
            val myPassword = userDataProvider.getPassword()

            if (myPassword == password && myPhone == phone) {
                val intent = Intent(context, MainActivity::class.java )
                startActivity(intent)
                finish()

                return@setOnClickListener
            }

            val error = "Invalid username or password!!!"
            tvError.visibility = View.VISIBLE
            tvError.text = error
        }


    }


}