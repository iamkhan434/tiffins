package com.example.tiffin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tiffin.R

class OffersAdapter(private val list: ArrayList<Int>): RecyclerView.Adapter<OffersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_offer, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.imgOffer.setImageResource(list[position])

    }


    class MyViewHolder (view: View): RecyclerView.ViewHolder(view) {

        val imgOffer: ImageView = view.findViewById(R.id.imgOffer)

    }

}