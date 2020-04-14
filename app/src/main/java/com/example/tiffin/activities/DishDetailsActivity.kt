package com.example.tiffin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiffin.R
import kotlinx.android.synthetic.main.activity_dish_details.*

class DishDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_details)

        imgBack.setOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name")!!
        val hotel = intent.getStringExtra("hotel")!!
        val price = intent.getDoubleExtra("price", 0.0)
        val type = intent.getStringExtra("type")!!
        val foodImage = intent.getIntExtra("foodImage", 0)

        tvTitle.text = name
        tvHotel.text = hotel
        tvPrice.text = price.toString()

        imgDish.setImageResource(foodImage)


        when(type) {

            "VEG" -> {
                tvType.text = "Veg"
                tvType.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_veg, 0,0,0)
            }
            "NON_VEG" -> {
                tvType.text = "Non Veg"
                tvType.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_non_veg, 0,0,0)
            }
            "EGG" -> {
                tvType.text = "Egg"
                tvType.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_egg, 0,0,0)
            }


        }

    }
}
