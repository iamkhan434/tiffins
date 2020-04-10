package com.example.tiffin.utils

import android.content.Context
import com.example.tiffin.data.User

class UserDataProvider(context: Context) {

    private val preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)

    fun saveUser(name: String, phone: String, email: String, password: String) {

        val editor = preferences.edit()

        editor.putString("name", name)
        editor.putString("phone", phone)
        editor.putString("email", email)
        editor.putString("password", password)

        editor.apply()
    }

    fun saveUser(user: User) {

        val editor = preferences.edit()

        editor.putString("name", user.name)
        editor.putString("phone", user.phone)
        editor.putString("email", user.email)
        editor.putString("password", user.password)

        editor.apply()
    }

    fun getUser(): User {

        return User(
                preferences.getString("name", "")!!,
                preferences.getString("phone", "")!!,
                preferences.getString("email", "")!!,
                preferences.getString("password", "")!!
        )

    }

    fun getName(): String {
        return preferences.getString("name", "")!!
    }

    fun getPhone(): String = preferences.getString("phone","")!!

    fun getEmail(): String = preferences.getString("email","")!!

    fun getPassword(): String = preferences.getString("password","")!!


    fun logout() {

        val editor = preferences.edit()
        editor.clear()
        editor.apply()

    }

}