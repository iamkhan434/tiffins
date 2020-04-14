package com.example.tiffin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tiffin.R
import com.example.tiffin.data.Dish

class DishAdapter(private val list: ArrayList<Dish>, private val dishClickListener: DishClickListener): RecyclerView.Adapter<DishAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val dish = list[position]

        holder.tvName.text = dish.name
        holder.tvHotel.text = dish.hotel
        holder.tvPrice.text = dish.price.toString()

        holder.imgDish.setImageResource(dish.foodImage)

        when(dish.type) {

            Dish.FoodType.VEG -> {
                holder.imgVeg.setImageResource(R.drawable.ic_veg)
            }
            Dish.FoodType.NON_VEG -> {
                holder.imgVeg.setImageResource(R.drawable.ic_non_veg)
            }
            Dish.FoodType.EGG -> {
                holder.imgVeg.setImageResource(R.drawable.ic_egg)
            }

        }

        holder.itemView.setOnClickListener {
            dishClickListener.onDishClick(dish)
        }

    }


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvHotel: TextView = view.findViewById(R.id.tvHotel)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)

        val imgDish: ImageView = view.findViewById(R.id.imgFood)
        val imgVeg: ImageView = view.findViewById(R.id.imgVeg)
    }

    interface DishClickListener{

        fun onDishClick(dish: Dish)

    }

}