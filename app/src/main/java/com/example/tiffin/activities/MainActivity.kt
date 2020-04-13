package com.example.tiffin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.tiffin.R
import com.example.tiffin.fragments.HomeFragment
import com.example.tiffin.fragments.OrdersFragment
import com.example.tiffin.fragments.SettingsFragment
import com.example.tiffin.fragments.SubscriptionsFragment
import com.example.tiffin.utils.UserDataProvider
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener   {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        tvLogout.setOnClickListener {

            val userDataProvider = UserDataProvider(context)
            userDataProvider.logout()

            startActivity(Intent(context, LoginActivity::class.java))

            finish()

        }

        nav_view.setNavigationItemSelectedListener(this)


        showUserInfo()

        showHome()

    }


    private fun showUserInfo() {

        val userDataProvider = UserDataProvider(context)

        val name = userDataProvider.getName()
        val phone = userDataProvider.getPhone()

        val header = nav_view.getHeaderView(0)

        val tvName: TextView = header.findViewById(R.id.tvName)
        val tvMobile: TextView = header.findViewById(R.id.tvMobile)

        tvName.text = name
        tvMobile.text = phone

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when(item.itemId) {

            R.id.navHome ->{
                showFragment(HomeFragment(), "Home")
            }
            R.id.navOrders ->{
                showFragment(OrdersFragment(),"Orders")
            }
            R.id.navSubscriptions ->{
                showFragment(SubscriptionsFragment(),"Subscriptions")
            }
            R.id.navSettings ->{
                showFragment(SettingsFragment(),"Settings")
            }

        }

        toggleMenu()

        return true
    }

    private fun showFragment(fragment: Fragment, tag: String) {

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragmentView, fragment, tag)
        ft.addToBackStack(tag)
        ft.commit()

    }

    private fun showHome() {

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmentView, HomeFragment(), "Home")
        ft.commit()

    }


    private fun showMessage(msg: String) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    }

    fun toggleMenu() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {

            drawer_layout.closeDrawer(GravityCompat.START)

        }else {

            drawer_layout.openDrawer(GravityCompat.START)

        }

    }

}
