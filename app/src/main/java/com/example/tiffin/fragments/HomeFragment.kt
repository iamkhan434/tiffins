package com.example.tiffin.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.tiffin.R
import com.example.tiffin.activities.DishDetailsActivity
import com.example.tiffin.activities.MainActivity
import com.example.tiffin.adapters.DishAdapter
import com.example.tiffin.adapters.OffersAdapter
import com.example.tiffin.data.Dish
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgNav.setOnClickListener {
            (activity as MainActivity).toggleMenu()
        }


        showOffers()

        showDishes()

    }

    private fun showDishes() {

        val dishes = ArrayList<Dish>()

        dishes.add(
                Dish(
                        "Pizza",
                        "PizzaHurt",
                        199.0,
                        R.drawable.food_1,
                        Dish.FoodType.VEG
                )
        )

        dishes.add(
                Dish(
                        "Biriyani",
                        "Shalimar",
                        150.0,
                        R.drawable.food_2,
                        Dish.FoodType.NON_VEG
                )
        )

        dishes.add(
                Dish(
                        "Palak Paneer",
                        "Shalimar",
                        120.0,
                        R.drawable.food_3,
                        Dish.FoodType.VEG
                )
        )


        dishes.add(
                Dish(
                        "Butter Chicken",
                        "Mughal Darbar",
                        300.0,
                        R.drawable.food_4,
                        Dish.FoodType.NON_VEG
                )
        )
        dishes.add(
                Dish(
                        "Egg Biriyani",
                        "Delhi Jaeka",
                        180.0,
                        R.drawable.food_5,
                        Dish.FoodType.EGG
                )
        )

        val dishClickListener = object : DishAdapter.DishClickListener {

            override fun onDishClick(dish: Dish) {

                Toast.makeText(requireContext(), dish.name, Toast.LENGTH_SHORT).show()

                val intent = Intent(requireContext(), DishDetailsActivity::class.java)

                intent.putExtra("name", dish.name)
                intent.putExtra("hotel", dish.hotel)
                intent.putExtra("price", dish.price)
                intent.putExtra("foodImage", dish.foodImage)
                intent.putExtra("type", dish.type.toString())

                startActivity(intent)
            }

        }

        val adapter = DishAdapter(dishes, dishClickListener)
        rvFood.adapter = adapter

    }

    private fun showOffers() {

        val offers = ArrayList<Int>()

        offers.add(R.drawable.offer_1)
        offers.add(R.drawable.offer_2)
        offers.add(R.drawable.offer_3)
        offers.add(R.drawable.offer_4)
        offers.add(R.drawable.offer_5)

        val adapter = OffersAdapter(offers)
        rvOffers.adapter = adapter

    }

}
