package com.example.tiffin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiffin.R
import com.example.tiffin.data.User
import com.example.tiffin.utils.UserDataProvider
import kotlinx.android.synthetic.main.activity_signup.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        context = this@RegisterActivity

        btnRegister.setOnClickListener {

            val name = etName.text.toString().trim()

            if (name.length < 3) {

                mfName.error = "Enter Name"

                return@setOnClickListener
            }

            mfName.error = null

            val phone = etPhone.text.toString().trim()

            if (phone.length != 10) {

                mfPhone.error = "Enter valid number"

                return@setOnClickListener
            }

            mfPhone.error = null

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (password.length < 4) {
                mfPassword.error = "Must be 4 or more characters"

                return@setOnClickListener
            }

            mfPassword.error = null


            val userDataProvider = UserDataProvider(context)
            val user = User(name, phone, email, password)
            userDataProvider.saveUser(user)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)

            finish()
        }

        btnLogin.setOnClickListener {
            startActivity( Intent(context, LoginActivity::class.java))
            finish()
        }


    }


}