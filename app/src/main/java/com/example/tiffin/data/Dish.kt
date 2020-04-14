package com.example.tiffin.data

data class Dish(
        val name: String,
        val hotel: String,
        val price: Double,
        val foodImage: Int,
        val type: FoodType

){


    enum class FoodType{
        VEG,
        NON_VEG,
        EGG
    }

}
